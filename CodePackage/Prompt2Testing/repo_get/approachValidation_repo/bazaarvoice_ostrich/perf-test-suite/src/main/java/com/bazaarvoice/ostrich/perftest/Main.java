package com.bazaarvoice.ostrich.perftest;

import com.bazaarvoice.ostrich.perftest.utils.Arguments;
import com.bazaarvoice.ostrich.perftest.utils.LoadRunner;

public class Main {

    public static void main(String args[]) {

        Arguments arguments = new Arguments(args);
        LoadRunner loadRunner = new LoadRunner(arguments);

        loadRunner.printHeaders();
        do {
            loadRunner.printLog();
        } while (loadRunner.shouldContinue());
    }
}
