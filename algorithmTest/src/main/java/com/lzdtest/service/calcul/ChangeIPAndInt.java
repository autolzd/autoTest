package com.lzdtest.service.calcul;

public class ChangeIPAndInt {
    public static void main(String[] args) {
        String a = numToIp("167969729");
        System.out.println(a);
    }

    /**
     * 把ip 截取成4个整数
     * 转换成 二进制的
     * 再转成十进制的
     * StringBuilder.append
     */
    private static Long ipToNum(String inputStr) {
        String[] a = inputStr.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String b : a) {
            int c = Integer.parseInt(b);
            String num2 = Integer.toBinaryString(c);//转成二进制
            while (num2.length() < 8) {
                num2 = "0" + num2;
            }
            sb.append(num2);
        }
        return Long.parseLong(sb.toString(), 2);
    }

    private static String numToIp(String inputStr) {
        String num = Integer.toBinaryString(Integer.parseInt(inputStr));//十进制转成二进制
        while (num.length() < 32) {
            num = "0" + num;
        }
        String[] str = new String[4];
        for (int i = 0; i < str.length; i++) {
            String s = num.substring(8 * i, 8 * i + 8);
            s = Integer.toString(Integer.parseInt(s, 2));
            str[i] = s;
        }
        return String.join(".", str);
    }
}
