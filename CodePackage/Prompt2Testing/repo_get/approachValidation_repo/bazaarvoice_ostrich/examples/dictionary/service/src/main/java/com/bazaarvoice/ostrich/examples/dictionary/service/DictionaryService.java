package com.bazaarvoice.ostrich.examples.dictionary.service;

import com.bazaarvoice.ostrich.ServiceEndPoint;
import com.bazaarvoice.ostrich.ServiceEndPointBuilder;
import com.bazaarvoice.ostrich.registry.zookeeper.ZooKeeperServiceRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jetty.ConnectorFactory;
import io.dropwizard.jetty.HttpConnectorFactory;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.server.ServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.curator.framework.CuratorFramework;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.InetAddress;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * A Dropwizard+Jersey-based client of a simple dictionary service.
 */
public class DictionaryService extends Application<DictionaryConfiguration> {
    public static Response.Status STATUS_OVERRIDE = Response.Status.OK;

    @Override
    public void initialize(Bootstrap<DictionaryConfiguration> bootstrap) {
    }

    @Override
    public void run(DictionaryConfiguration config, final Environment env) throws Exception {
        // Load the subset of the dictionary handled by this server.
        WordList wordList = new WordList(config.getWordFile(), config.getWordRange());

        env.jersey().register(new DictionaryResource(wordList, config.getWordRange()));
        env.jersey().register(ToggleHealthResource.class);
        env.jersey().register(new IllegalArgumentExceptionMapper());
        env.healthChecks().register("dictionary", new DictionaryHealthCheck());

        InetAddress localhost = InetAddress.getLocalHost();
        String host = localhost.getHostName();
        String ip = localhost.getHostAddress();
        int port = getHttpPort(config);
        int adminPort = getAdminHttpPort(config);

        // The client reads the URLs out of the payload to figure out how to connect to this server.
        URI serviceUri = UriBuilder.fromResource(DictionaryResource.class).scheme("http").host(ip).port(port).build();
        URI adminUri = UriBuilder.fromPath("").scheme("http").host(ip).port(adminPort).build();
        Map<String, ?> payload = ImmutableMap.of(
                "url", serviceUri,
                "adminUrl", adminUri,
                "partition", config.getWordRange());
        final ServiceEndPoint endPoint = new ServiceEndPointBuilder()
                .withServiceName(env.getName())
                .withId(host + ":" + port)
                .withPayload(getJson(env).writeValueAsString(payload))
                .build();

        final CuratorFramework curator = config.getZooKeeperConfiguration().newManagedCurator(env.lifecycle());
        env.lifecycle().manage(new Managed() {
            ZooKeeperServiceRegistry registry = new ZooKeeperServiceRegistry(curator, env.metrics());

            @Override
            public void start() throws Exception {
                registry.register(endPoint);
            }

            @Override
            public void stop() throws Exception {
                registry.unregister(endPoint);
            }
        });
    }

    private ObjectMapper getJson(Environment env) {
        return env.getObjectMapper();
    }

    private int getHttpPort(Configuration config) {
        ServerFactory serverFactory = config.getServerFactory();
        if (!(serverFactory instanceof DefaultServerFactory)) {
            throw new IllegalStateException("Server factory is not an instance of DefaultServerFactory");
        }

        List<ConnectorFactory> connectors = ((DefaultServerFactory) serverFactory).getApplicationConnectors();
        for (ConnectorFactory connector : connectors) {
            if (connector instanceof HttpConnectorFactory) {
                return ((HttpConnectorFactory) connector).getPort();
            }
        }

        throw new IllegalStateException("Unable to determine HTTP port");
    }

    private int getAdminHttpPort(Configuration config) {
        ServerFactory serverFactory = config.getServerFactory();
        if (!(serverFactory instanceof DefaultServerFactory)) {
            throw new IllegalStateException("Server factory is not an instance of DefaultServerFactory");
        }

        List<ConnectorFactory> connectors = ((DefaultServerFactory) serverFactory).getAdminConnectors();
        for (ConnectorFactory connector : connectors) {
            if (connector instanceof HttpConnectorFactory) {
                return ((HttpConnectorFactory) connector).getPort();
            }
        }

        throw new IllegalStateException("Unable to determine admin HTTP port");
    }

    public static void main(String[] args) throws Exception {
        new DictionaryService().run(args);
    }
}
