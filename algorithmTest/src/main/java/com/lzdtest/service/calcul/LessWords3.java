package com.lzdtest.service.calcul;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LessWords3 {
    /**
     * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。
     * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     */
    private static String delLessWords(String inputStr) {
        char[] aChar = inputStr.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : aChar) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Collection<Integer> collection = map.values();
        int num = Collections.min(collection);
        for (Character character : map.keySet()) {
            if (map.get(character) == num) {
                inputStr = inputStr.replaceAll(String.valueOf(character), "");
            }
        }
        return inputStr;
    }

    public static void main(String[] args) {
        String str = "aacnnmhj";
        String res = delLessWords(str);
        System.out.println(res);
    }
}
