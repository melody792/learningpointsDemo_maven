package com.pzb.PMD;

public class Demo {
    public static void main(String[] args) {
//        String hue= "22.2";
//        hue = Integer.toString(Integer.parseInt(hue));
        String str = toSanitizedTenantName(null);
        System.out.println(str);
    }

    public static final String toSanitizedTenantName(String tenant) {
        if (tenant == null) {
            return null;
        }
        return tenant.toLowerCase() // convert upper case characters to lowercase characters because upper case characters are illegal
                .replaceAll("[^a-z0-9\\_$\\(\\)+\\-\\/]", ""); // remove illegal cloudant database name characters
    }
}
