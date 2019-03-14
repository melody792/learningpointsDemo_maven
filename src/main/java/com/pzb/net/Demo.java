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
package com.pzb.net;

import com.google.common.collect.ImmutableList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * create by pzhbao on 04/03/2019
 */
public class Demo {
    private static URL url;
    private static HttpURLConnection con;
    private static int state = -1;
    public static final Set<String> CLOUDANT_SECTIONS_LIST = new HashSet<>();

    /**
     * 功能：检测当前URL是否可连接或是否有效,
     * 描述：最多连接网络 5 次, 如果 5 次都不成功，视为该地址不可用
     * @param urlStr 指定URL网络地址
     * @return URL
     */
    public synchronized URL isConnect(String urlStr) {
        int counts = 0;
        if (urlStr == null || urlStr.length() <= 0) {
            return null;
        }
        while (counts < 5) {
            try {
                url = new URL(urlStr);
                con = (HttpURLConnection) url.openConnection();
                state = con.getResponseCode();
                System.out.println(counts +"= "+state);
                if (state == 200) {
                    System.out.println("URL可用！");
                }
                break;
            }catch (Exception ex) {
                counts++;
                System.out.println("URL不可用，连接第 "+counts+" 次");
                urlStr = null;
                continue;
            }
        }
        return url;
    }
    public static void main(String[] args) {
        Demo u = new Demo();
        CLOUDANT_SECTIONS_LIST.add("hello");
        CLOUDANT_SECTIONS_LIST.add("hello");
        CLOUDANT_SECTIONS_LIST.forEach(s -> System.out.println(s));
    }
}
