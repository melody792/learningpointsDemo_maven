package com.pzb.guice;

import com.google.inject.AbstractModule;

public class MyAppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(GuiceDemoService.class).to(GuiceDemoServiceImpl.class);
        bind(LogService.class).to(LogServiceImpl.class);
    }
}
