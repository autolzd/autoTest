package com.lzdtest.service.calcul;

public class ChangeIP2 {
    public static void main(String[] args) {
//        String result = tenToTow("10.0.3.193");
        String result = numToIp("167969729");
        System.out.println(result);
    }

    private static Long ipToNum(String inputStr) {
        String[] ip = inputStr.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String ips : ip) {
            String num = Integer.toBinaryString(Integer.parseInt(ips));
            while (num.length() < 8) {
                num = "0" + num;//转成2进制 可能少一位
            }
            sb.append(num);
        }
        return Long.parseLong(sb.toString(), 2);//二进制转十进制
    }

    //十进制转二进制
    private static String tenToTow(String inputStr) {
        String num = Integer.toBinaryString(Integer.parseInt(inputStr));//十进制转二进制
        while (num.length() < 8) {
            num = "0" + num;
        }
        return num;
    }

    private static String numToIp(String inputStr) {
        String num = Integer.toBinaryString(Integer.parseInt(inputStr));//十进制转成二进制
        while (num.length() < 32) {
            num = "0" + num;
        }
        String[] str = new String[4];
        for (int i = 0; i < 4; i++) {
            String s = num.substring(8 * i, 8 * i + 8);
            s = Integer.toString(Integer.parseInt(s,2));
            str[i] = s;
        }
        return String.join(".", str);
    }
}
