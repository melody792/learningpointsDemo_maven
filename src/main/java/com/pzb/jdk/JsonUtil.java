package com.pzb.jdk;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse("{id:\"1\"}");
        System.out.println();
    }
}
