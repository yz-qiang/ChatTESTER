package com.bazaarvoice.ostrich.perftest.core;

public class SimpleResultFactory implements ResultFactory<String> {

    private SimpleResultFactory() {
    }

    public static SimpleResultFactory newInstance() {
        return new SimpleResultFactory();
    }

    @Override
    public Result<String> createResponse(final String result) {
        return new Result<String>() {
            @Override
            public boolean hasError() {
                return false;
            }

            @Override
            public Exception getException() {
                return null;
            }

            @Override
            public String getResult() {
                return result;
            }
        };
    }

    @Override
    public Result<String> createResponse(final Exception error) {
        return new Result<String>() {
            @Override
            public boolean hasError() {
                return true;
            }

            @Override
            public Exception getException() {
                return error;
            }

            @Override
            public String getResult() {
                return null;
            }
        };
    }
}
