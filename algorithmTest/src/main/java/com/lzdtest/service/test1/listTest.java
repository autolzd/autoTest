package com.lzdtest.service.test1;


import java.util.ArrayList;
import java.util.List;

public class listTest {
    public static void main(String[] args) {
        String a = backbreaking3("asb");
        System.out.println(a);
    }

    private static List<String> listTest(){
        List<String> str = new ArrayList<String>();
        str.remove(1);
        return  str;
    }

    private static String breackxunhuan(String testStr){
        if (testStr.isEmpty()) return "字段为空";
        char[] charStr = testStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < testStr.length(); i++){
            String res = String.valueOf(charStr[i]);
            stringBuilder.append(res).append(",");
            if (res.equals("s")) break;
        }
        return stringBuilder.toString();
    }

    private static String breackxunhuan2(String testStr){
        if (testStr.isEmpty()) return "字段为空";
        char[] charStr = testStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < testStr.length(); i++){
            String res = String.valueOf(charStr[i]);
            if (res.equals("s")) continue;
            stringBuilder.append(res).append(",");
        }
        return stringBuilder.toString();
    }

    private static String backbreaking3(String testStr){
        if (testStr.isEmpty()) return "字段为空";
        char[] charStr = testStr.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < testStr.length(); i++){
            String res = String.valueOf(charStr[i]);
            if (res.equals("s")) return "结束";
            stringBuilder.append(res).append(",");
        }
        throw new IllegalArgumentException("结束啦");
    }
}
