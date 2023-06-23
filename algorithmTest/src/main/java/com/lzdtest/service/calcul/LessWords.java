package com.lzdtest.service.calcul;

import java.util.*;

public class LessWords {


    /**
     * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。
     * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     */
    public static void main(String[] args) {
        String str = "aabbcccss";
        String map = getLessWords(str);
        System.out.println(map);
    }

    private static Integer testMapGetOrDefault(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char achar : chars) {
            map.put(achar, map.getOrDefault(achar, 0) + 1);
        }
        Collection<Integer> collection = map.values();
        Integer a = Collections.min(collection);
        return a;
    }

    private static String getLessWords(String inputWords) {
        Map<Character, Integer> map = new HashMap<>();
        char[] aChar = inputWords.toCharArray();
        for (char c : aChar) {
            //如果存在key 则返回key对应的val，并且+1； 否则返回默认值
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Collection<Integer> collection = map.values();
        Integer a = Collections.min(collection);
        for (Character character : map.keySet()) {
            if (map.get(character) == a) {
                inputWords = inputWords.replaceAll(String.valueOf(character), "");
            }
        }
        return inputWords;
    }
}
