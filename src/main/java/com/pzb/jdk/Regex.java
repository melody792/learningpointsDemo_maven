package com.pzb.jdk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class Regex {
    public static void main(String[] args) {
        //testMatches();
        testFind();
    }

    private static void testFind() {
        // 要验证的字符串
        String str = "aaa2bbb2ccc";
        // 正则表达式规则
        String regEx = "(.*)\\$(.*)\\$(.*)";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
        boolean rs = matcher.find();
        if(rs){
            int count = matcher.groupCount();
            System.out.println("group count " + count);
            for(int i=0; i<count; i++){
                System.out.println(matcher.group(2));
            }
        }else{
            System.out.println("can not find");
        }
    }

    private static void testMatches() {
        // 要验证的字符串
        String str = "service@xsoftlab.net";
        // 邮箱验证规则
        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);
    }
}
