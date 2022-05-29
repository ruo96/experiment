package com.experiment.algo.slidewindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuruohong
 * @date 2022-05-30 1:09
 */
public class Most2DifferentSubString {

    @Test
    public void Test10() {

        String s ="aaaccacacacacaacdddccccaddc";
        System.out.println("getResult(s) = " + getResult(s));

    }

    public int getResult(String s) {

        if (s == null) {
            return 0;
        }
        if (s.length() <= 2) {
            return s.length();
        }

        int left=0, right =0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() <= 2) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            while (map.size() > 2) {
                c = s.charAt(left++);
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return maxLength;
    }


}
