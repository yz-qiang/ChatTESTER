package com.bazaarvoice.ostrich.examples.dictionary.user;

import com.bazaarvoice.ostrich.discovery.zookeeper.ZooKeeperHostDiscovery;
import com.bazaarvoice.ostrich.dropwizard.healthcheck.ContainsHealthyEndPointCheck;
import com.bazaarvoice.ostrich.examples.dictionary.client.DictionaryService;
import com.bazaarvoice.ostrich.examples.dictionary.client.DictionaryServiceFactory;
import com.bazaarvoice.ostrich.pool.ServiceCachingPolicy;
import com.bazaarvoice.ostrich.pool.ServiceCachingPolicyBuilder;
import com.bazaarvoice.ostrich.pool.ServicePoolBuilder;
import com.bazaarvoice.ostrich.pool.ServicePoolProxies;
import com.bazaarvoice.ostrich.retry.ExponentialBackoffRetry;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.io.Closeables;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import io.dropwizard.client.JerseyClientConfiguration;
import io.dropwizard.configuration.ConfigurationException;
import io.dropwizard.configuration.ConfigurationFactory;
import io.dropwizard.configuration.YamlConfigurationFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.util.JarLocation;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validation;
import javax.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DictionaryUser {
    private static final Logger LOG = LoggerFactory.getLogger(DictionaryUser.class);

    private static final CharMatcher LETTER = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z'));

    private final DictionaryService _service;

    public DictionaryUser(DictionaryService service) {
        _service = service;
    }

    public void spellCheck(File file) throws IOException {
        LOG.info("Spell checking file: {}", file);
        Files.asCharSource(file, Charsets.UTF_8).readLines(new LineProcessor<Void>() {
            @Override
            public boolean processLine(String line) throws IOException {
                for (String word : Splitter.on(CharMatcher.whitespace()).split(line)) {
                    // Discard punctuation, numbers, etc.
                    word = LETTER.retainFrom(word);
                    if (!word.isEmpty()) {
                        spellCheck(word);
                    }
                }
                return true;
            }

            @Override
            public Void getResult() {
                return null;
            }
        });
    }

    public void spellCheck(String word) {
        try {
            if (_service.contains(word.toLowerCase())) {
                LOG.info("ok: {}", word);
            } else {
                LOG.info("MISSPELLED: {}", word);
            }
        } catch (Exception e) {
            LOG.warn("word:{}, {}", word, e);
        }

        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            // ignored
        }
    }

    public static void main(String[] args) throws Exception {
        Namespace parsedArgs = parseCommandLine(args);

        // Load the config.yaml file specified as the first argument.
        DictionaryConfiguration config = loadConfigFile(parsedArgs.getString("config-file"));

        CuratorFramework curator = config.getZooKeeperConfiguration().newCurator();
        curator.start();

        // Connection caching is optional, but included here for the sake of demonstration.
        ServiceCachingPolicy cachingPolicy = new ServiceCachingPolicyBuilder()
                .withMaxNumServiceInstances(10)
                .withMaxNumServiceInstancesPerEndPoint(1)
                .withMaxServiceInstanceIdleTime(5, TimeUnit.MINUTES)
                .build();

        // The service is partitioned, but partition filtering is configured by the ServiceFactory in this case
        // when the builder calls its configure() method.
        JerseyClientConfiguration httpClientConfiguration = config.getHttpClientConfiguration();
        MetricRegistry metrics = new MetricRegistry();
        DictionaryServiceFactory serviceFactory = new DictionaryServiceFactory(httpClientConfiguration, metrics);
        DictionaryService service = ServicePoolBuilder.create(DictionaryService.class)
                .withServiceFactory(serviceFactory)
                .withHostDiscovery(new ZooKeeperHostDiscovery(curator, serviceFactory.getServiceName(), metrics))
                .withMetricRegistry(metrics)
                .withCachingPolicy(cachingPolicy)
                .buildProxy(new ExponentialBackoffRetry(5, 50, 1000, TimeUnit.MILLISECONDS));

        // If using Yammer Metrics or running in Dropwizard (which includes Yammer Metrics), you may want a health
        // check that pings a service you depend on. This will register a simple check that will confirm the service
        // pool contains at least one healthy end point.
        HealthCheckRegistry healthChecks = new HealthCheckRegistry();
        healthChecks.register("dictionary-user", ContainsHealthyEndPointCheck.forProxy(service));

        DictionaryUser user = new DictionaryUser(service);
        for (String wordFile : parsedArgs.<String>getList("word-file")) {
            user.spellCheck(new File(wordFile));
        }

        ServicePoolProxies.close(service);
        Closeables.close(curator, true);
    }

    private static Namespace parseCommandLine(String[] args) throws ArgumentParserException {
        String usage = "java -jar " + new JarLocation(DictionaryUser.class);
        ArgumentParser argParser = ArgumentParsers.newArgumentParser(usage).defaultHelp(true);
        argParser.addArgument("config-file").nargs("?").help("yaml configuration file");
        argParser.addArgument("word-file").nargs("+").help("one or more files containing words");
        return argParser.parseArgs(args);
    }

    private static DictionaryConfiguration loadConfigFile(String configFile)
            throws IOException, ConfigurationException {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        ConfigurationFactory<DictionaryConfiguration> configFactory = new YamlConfigurationFactory<>(
                DictionaryConfiguration.class, validator, Jackson.newObjectMapper(), "dictionary"
        );
        if (configFile != null) {
            return configFactory.build(new File(configFile));
        } else {
            return configFactory.build();
        }
    }
}
