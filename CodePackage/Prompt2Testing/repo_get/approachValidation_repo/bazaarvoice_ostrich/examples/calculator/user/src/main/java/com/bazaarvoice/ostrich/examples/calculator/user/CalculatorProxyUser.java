package com.bazaarvoice.ostrich.examples.calculator.user;

import com.bazaarvoice.ostrich.discovery.zookeeper.ZooKeeperHostDiscovery;
import com.bazaarvoice.ostrich.dropwizard.healthcheck.ContainsHealthyEndPointCheck;
import com.bazaarvoice.ostrich.examples.calculator.client.CalculatorService;
import com.bazaarvoice.ostrich.examples.calculator.client.CalculatorServiceFactory;
import com.bazaarvoice.ostrich.pool.ServiceCachingPolicy;
import com.bazaarvoice.ostrich.pool.ServiceCachingPolicyBuilder;
import com.bazaarvoice.ostrich.pool.ServicePoolBuilder;
import com.bazaarvoice.ostrich.pool.ServicePoolProxies;
import com.bazaarvoice.ostrich.retry.ExponentialBackoffRetry;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.google.common.io.Closeables;
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
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Variation of {@link CalculatorUser} that uses a dynamic service proxy instead of making direct calls to
 * {@link com.bazaarvoice.ostrich.ServicePool}.
 */
public class CalculatorProxyUser {
    private static final Logger LOG = LoggerFactory.getLogger(CalculatorProxyUser.class);

    private final Random _random = new Random();
    private final CalculatorService _service;

    public CalculatorProxyUser(CalculatorService service) {
        _service = service;
    }

    public void use() throws InterruptedException {
        int i = 0;
        while (++i > 0) {
            try {
                int a = _random.nextInt(10);
                int b = 1 + _random.nextInt(9);
                int op = _random.nextInt(4);
                int result = call(op, a, b);
                LOG.info("i:{}, result:{}", i, result);
            } catch (Exception e) {
                LOG.info("i:{}, {}", i, e.getClass().getCanonicalName());
            }

            Thread.sleep(100);
        }
    }

    private int call(int op, int a, int b) {
        switch (op) {
            case 0:  return _service.add(a, b);
            case 1:  return _service.sub(a, b);
            case 2:  return _service.mul(a, b);
            default: return _service.div(a, b);
        }
    }

    public static void main(String[] args) throws Exception {
        Namespace parsedArgs = parseCommandLine(args);

        // Load the config.yaml file specified as the first argument (optional).
        CalculatorConfiguration config = loadConfigFile(parsedArgs.getString("config-file"));

        // Connect to ZooKeeper
        CuratorFramework curator = config.getZooKeeperConfiguration().newCurator();
        curator.start();

        // Connection caching is optional, but included here for the sake of demonstration.
        ServiceCachingPolicy cachingPolicy = new ServiceCachingPolicyBuilder()
                .withMaxNumServiceInstances(10)
                .withMaxNumServiceInstancesPerEndPoint(1)
                .withMaxServiceInstanceIdleTime(5, TimeUnit.MINUTES)
                .build();

        JerseyClientConfiguration httpClientConfiguration = config.getHttpClientConfiguration();
        MetricRegistry metrics = new MetricRegistry();
        CalculatorServiceFactory serviceFactory = new CalculatorServiceFactory(httpClientConfiguration, metrics);
        CalculatorService service = ServicePoolBuilder.create(CalculatorService.class)
                .withServiceFactory(serviceFactory)
                .withHostDiscovery(new ZooKeeperHostDiscovery(curator, serviceFactory.getServiceName(), metrics))
                .withMetricRegistry(metrics)
                .withCachingPolicy(cachingPolicy)
                .buildProxy(new ExponentialBackoffRetry(5, 50, 1000, TimeUnit.MILLISECONDS));

        // If using Yammer Metrics or running in Dropwizard (which includes Yammer Metrics), you may want a health
        // check that pings a service you depend on. This will register a simple check that will confirm the service
        // pool contains at least one healthy end point.
        HealthCheckRegistry healthChecks = new HealthCheckRegistry();
        healthChecks.register("calculator-user", ContainsHealthyEndPointCheck.forProxy(service));

        CalculatorProxyUser user = new CalculatorProxyUser(service);
        user.use();

        ServicePoolProxies.close(service);
        Closeables.close(curator, true);
    }

    private static Namespace parseCommandLine(String[] args) throws ArgumentParserException {
        String usage = "java -jar " + new JarLocation(CalculatorProxyUser.class);
        ArgumentParser argParser = ArgumentParsers.newArgumentParser(usage).defaultHelp(true);
        argParser.addArgument("config-file").nargs("?").help("yaml configuration file");
        return argParser.parseArgs(args);
    }

    private static CalculatorConfiguration loadConfigFile(String configFile) throws IOException,
            ConfigurationException {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        ConfigurationFactory<CalculatorConfiguration> configFactory = new YamlConfigurationFactory<>(
                CalculatorConfiguration.class, validator, Jackson.newObjectMapper(), "calculator"
        );
        if (configFile != null) {
            return configFactory.build(new File(configFile));
        } else {
            return configFactory.build();
        }
    }
}
