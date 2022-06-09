package com.experiment.algo.ten10;

import org.junit.Test;

import java.util.*;

/**
 * @author wuruohong
 * @date 2022-05-28 16:10
 * 给定一个字符串，找到其中不含有重复字符串的子串的长度
 */
public class LongestNorepeatSubString {
    String s = "abcdfadf";
    
    @Test
    public void Test12() {
        int result = getLongestNumSubString(s);
        System.out.println("result = " + result);
    }

    private int getLongestNumSubString(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        // 维护一个哈希set的窗口
        Set<Character> windows = new HashSet<>();
        int len = s.length();

        int res = 0;

        while (right < len) {
            char c = s.charAt(right);
            //  窗口右移
            right ++;

            while (windows.contains(c)) {
                windows.remove(s.charAt(left));
                left ++;
            }

            windows.add(c);
            res = Math.max(res, windows.size());
        }
        System.out.println("windows = " + windows);
        return res;
    }

    @Test
    public void Test56() {
        /**  用滑动窗口来获取包含子串的最小长度字符串*/
        String s ="abchs1j1stsfjs";
        String t = "ss";
        String result = getShortestSubString(s, t);
        System.out.println("result = " + result);
    }

    private String getShortestSubString(String s, String t) {

        int left = 0;
        int right = 0;
        Map<Character, Integer> need = new HashMap<>();
        int needCnt = t.length();

        /** 将目标字符串的所有字符先保存下来*/
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, 1 + need.getOrDefault(c, 0));
        }
        System.out.println("need = " + need);
        int size = Integer.MAX_VALUE;
        int start =0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.getOrDefault(c,-1) > 0) {
                // 满足条件也要减去一个
                needCnt--;
            }
            need.put(c, need.getOrDefault(c,0) - 1);


            if (needCnt == 0) {
                // 开始清理不需要的字符
                while (left < right && need.get(s.charAt(left)) < 0) {
                    need.put(s.charAt(left), need.get(s.charAt(left)) + 1);
                    left ++;
                }

                if (right - left + 1 < size) {
                    size = right-left+1;
                    start = left;
                }

                // 这个是要启动下一次的循环条件
                need.put(s.charAt(left), need.get(s.charAt(left))+1);
                left ++;
                needCnt++;

            }
            right++;
        }
        return size == Integer.MAX_VALUE?"":s.substring(start, start+size);



    }

    private String getShortestSubStringV2(String s, String t) {

        int left = 0;
        int right = 0;
        int[] need = new int[128];
        int needCnt = t.length();

        /** 将目标字符串的所有字符先保存下来*/
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need[c]++;
        }
        System.out.println("need = " + Arrays.toString(need));
        int size = Integer.MAX_VALUE;
        int start =0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need[c] > 0) {
                // 满足条件也要减去一个
                needCnt--;
            }
            need[c]--;

            if (needCnt == 0) {
                // 开始清理不需要的字符
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left ++;
                }

                if (right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }

                // 这个是要启动下一次的循环条件
                need[s.charAt(left)]++;
                left ++;
                needCnt++;

            }
            right++;
        }
        return size == Integer.MAX_VALUE?"":s.substring(start, start+size);



    }
}
