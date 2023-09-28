package com.bazaarvoice.ostrich.examples.dictionary.user;

import com.bazaarvoice.curator.dropwizard.ZooKeeperConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.client.JerseyClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * YAML-friendly configuration class.
 */
public class DictionaryConfiguration {
    @Valid
    @NotNull
    @JsonProperty
    private ZooKeeperConfiguration zooKeeper = new ZooKeeperConfiguration();

    @Valid
    @NotNull
    @JsonProperty
    private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();

    public ZooKeeperConfiguration getZooKeeperConfiguration() {
        return zooKeeper;
    }

    public JerseyClientConfiguration getHttpClientConfiguration() {
        return httpClient;
    }
}
