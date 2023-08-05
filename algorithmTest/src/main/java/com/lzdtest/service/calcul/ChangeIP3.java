package com.lzdtest.service.calcul;

import java.util.Arrays;

public class ChangeIP3 {

    private static Long changeIPToNum(String inputIP) {
        String[] ips = inputIP.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String num = Integer.toBinaryString(Integer.parseInt(ips[i]));
            while (num.length() < 8) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return Long.parseLong(sb.toString(), 2);
    }

    public static void main(String[] args) {
//        String ip = "29.3.52.633";
        String ip = "1946997369";
//        Long num = changeIPToNum(ip);
        String num = numToIP(ip);
        System.out.println(num);
    }

    private static String numToIP(String inputNum) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(Integer.parseInt(inputNum)));
        while (stringBuilder.length() < 32) {
            stringBuilder.insert(0, "0");
        }
        String[] strs = new String[4];
        for (int i = 0; i < 4; i++) {
            String s = stringBuilder.substring(8 * i, 8 * i + 8);
            s = Integer.toString(Integer.parseInt(s, 2));
            strs[i] = s;
        }
        System.out.println(Arrays.toString(strs));
        return String.join(".", strs);
    }
}
