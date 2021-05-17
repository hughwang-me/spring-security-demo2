package com.rx.springsecuritydemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Testing {

    public static void main(String[] args) {

        String origin = "31303030303030303030303031303033";
        int total = origin.length();
        for (int i = 0; i < total; ) {
            String item = origin.substring(i, i + 2);
            int version_item = Integer.parseInt(item, 16);
            i = i + 2;
        }

        Testing testing = new Testing();
        log.warn("转化结果: {}", testing.getVersionByCmdMsg(origin));
    }

    public String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);

            temp.append(decimal);
        }

        return sb.toString();
    }

    public String getVersionByCmdMsg(String msg) {

        int v1 = Integer.parseInt(substring(msg, 0, 2), 16);
        int v2 = Integer.parseInt(substring(msg, 2, 4), 16);
        int v3 = Integer.parseInt(substring(msg, 4, 6), 16);
        int v4 = Integer.parseInt(substring(msg, 6, 8), 16);
        log.warn("版本号1位 : " + substring(msg, 0, 2) + "  转成Int : " + (char)v1 + "  转数值"  + Integer.parseInt(String.valueOf((char)v1)));
        log.warn("版本号2位 : " + substring(msg, 2, 4) + "  转成Int : " + (char)v2 + "  转数值"  + Integer.parseInt(String.valueOf((char)v2)));
        log.warn("版本号3位 : " + substring(msg, 4, 6) + "  转成Int : " + (char)v3 + "  转数值"  + Integer.parseInt(String.valueOf((char)v3)));
        log.warn("版本号4位 : " + substring(msg, 6, 8) + "  转成Int : " + (char)v4 + "  转数值"  + Integer.parseInt(String.valueOf((char)v4)));

        return "" + v1 + v2;
    }

    public String substring(String msg, int start, int end) {
        String s = "";
        try {
            s = msg.substring(start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}
