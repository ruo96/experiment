package com.experiment.algo.slidewindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuruohong
 * @date 2022-05-29 23:40
 */
public class NoRepeatLongest {

    @Test
    public void Test10() {
        String s = "abcabcbb";
        System.out.println("getResult(s) = " + getResult(s));

    }

    public int getResult(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0, right=0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (right = 0; right < s.length();right++) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() == (right - left + 1)) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            while (map.size() < (right - left + 1)) {
                c = s.charAt(left++);
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
        }
        return maxLength;
    }

    public int getResultV2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                /** 这个移动left的方式确实巧妙*/
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            /** 这个思路确实巧妙啊*/
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
