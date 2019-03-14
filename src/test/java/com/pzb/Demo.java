/* ****************************************************************** */
/*                                                                    */
/* IBM Confidential                                                   */
/*                                                                    */
/* OCO Source Materials                                               */
/* 5900-A1H                                                           */
/* © Copyright IBM Corp. 2019                                         */
/*                                                                    */
/* The source code for this program is not published or otherwise     */
/* divested of its trade secrets, irrespective of what has been       */
/* deposited with the U.S. Copyright Office.                          */
/*                                                                    */
/* ****************************************************************** */
package com.pzb;

import com.pzb.log.Log;
import com.pzb.rxjava.RxJava;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * create by pzhbao on 24/01/2019
 */
public class Demo {
    @Test
    public void test(){
        Log.log(Logger.getLogger(RxJava.class.getName()), Level.INFO,"acme","demo.class","main","can not log");
    }
}
