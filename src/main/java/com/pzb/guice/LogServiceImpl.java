package com.pzb.guice;


import org.apache.commons.logging.Log;

import javax.inject.Inject;

public class LogServiceImpl implements LogService {
    @Inject
    private GuiceDemoService guiceDemoService;

    @Override
    public void invokePre (){
        guiceDemoService.prefetch();
    }
}

