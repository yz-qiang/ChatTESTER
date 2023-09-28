package com.bazaarvoice.ostrich.examples.calculator.service;

import com.codahale.metrics.health.HealthCheck;

import javax.ws.rs.core.Response;

public class CalculatorHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        if (CalculatorService.STATUS_OVERRIDE == Response.Status.OK) {
            return Result.healthy();
        } else {
            return Result.unhealthy("unhealthy by toggle");
        }
    }
}
