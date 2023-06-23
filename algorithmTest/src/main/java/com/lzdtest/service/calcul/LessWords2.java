package com.lzdtest.service.calcul;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LessWords2 {
    private static String delLessWord(String inputWord) {
        Map<Character, Integer> map = new HashMap<>();
        char[] aChar = inputWord.toCharArray();
        for (char chars : aChar) {
            map.put(chars, map.getOrDefault(chars, 0) + 1);
        }
        Collection<Integer> collection = map.values();
        Integer num = Collections.min(collection);
        for (Character character : map.keySet()) {
            if (map.get(character) == num) {
                inputWord = inputWord.replaceAll(String.valueOf(character), "");
            }
        }
        return inputWord;
    }
}
