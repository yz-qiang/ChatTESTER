package com.bazaarvoice.ostrich.examples.dictionary.service;

import com.codahale.metrics.health.HealthCheck;

import javax.ws.rs.core.Response;

public class DictionaryHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        if (DictionaryService.STATUS_OVERRIDE == Response.Status.OK) {
            return Result.healthy();
        } else {
            return Result.unhealthy("unhealthy by toggle");
        }
    }
}
