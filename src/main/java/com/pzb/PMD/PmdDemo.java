package com.pzb.PMD;

public class PmdDemo {

    public static void main(String[] args) {
        //new LogServiceImpl();
        //new GuiceDemoServiceImpl();
        //testindexof();
        testAndOr(null);
    }

    private static String testAndOr(String string) {
        String[] i = new String[0];
        // should be &&
        if (string!=null && !string.equals(""))
            return string;
        // should be ||
        if (string==null || string.equals(""))
            return string;
        return "";
    }

    private static void testindexof() {
        removeSlashes("333\\2222\\ssss");
    }
    private static String removeSlashes(String input) {
        int slashIndex = 0;
        String inputTemp = input;
        while (slashIndex < input.length() && (slashIndex = input.indexOf('\\', slashIndex)) != -1) {
            if (slashIndex < input.length() - 1 && input.charAt(slashIndex + 1) != '\\') {
                // add in a new slash and skip over
                inputTemp = input.substring(0, slashIndex) + "\\" + input.substring(slashIndex);

            }
            slashIndex += 2;
        }
        return inputTemp;
    }
    private static String removeSlashes1(String input) {
        int slashIndex = 0;
        String inputTemp = input;
        while (slashIndex < inputTemp.length() && (slashIndex = inputTemp.indexOf('\\', slashIndex)) != -1) {
            if (slashIndex < inputTemp.length() - 1 && inputTemp.charAt(slashIndex + 1) != '\\') {
                // add in a new slash and skip over
                inputTemp = inputTemp.substring(0, slashIndex) + "\\" + inputTemp.substring(slashIndex);

            }
            slashIndex += 2;
        }
        return inputTemp;
    }
}
