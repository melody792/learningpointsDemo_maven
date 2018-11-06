package com.pzb.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Demo {
    public static LogService logService;
    public static GuiceDemoService guiceDemoService;

    private static Injector injector = Guice.createInjector(new MyAppModule());

    public static void main(String[] args) {
        logService = injector.getInstance(LogService.class);
        guiceDemoService = injector.getInstance(GuiceDemoService.class);
        logService.invokePre();
        guiceDemoService.prefetch();
    }
}
