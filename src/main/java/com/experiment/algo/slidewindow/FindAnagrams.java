package com.experiment.algo.slidewindow;

import org.junit.Test;

import java.util.*;

/**
 * @author wuruohong
 * @date 2022-05-30 10:30
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {
    
    @Test
    public void Test22() {
        String s = "cbaebabacd";
        String p = "abc";
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            //System.out.println("findAnagrams(s,p) = " + findAnagrams(s, p));
            findAnagrams(s, p);
        }
        long s2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            //System.out.println("findAnagramsV2(s,p) = " + findAnagramsV2(s, p));
            findAnagramsV2(s, p);
        }
        long s3 = System.currentTimeMillis();
        System.out.println("(s2-s1) = " + (s2 - s1));
        System.out.println("(s3-s2) = " + (s3 - s2));

    }

    public List<Integer> findAnagrams(String s, String p) {
        int left =0,right = 0;
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Character c;
        for (right = 0; right < s.length(); right++) {
            c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.equals(targetMap)) {
                result.add(left);
            }

            if (right >= p.length() - 1) {
                c = s.charAt(left);
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                left++;
            }
        }

        return result;
    }

    public List<Integer> findAnagramsV2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    @Test
    public void Test57() {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        map1.put('a',1);
        map1.put('b',3);
        map2.put('b',2);
        map2.put('a',1);

        if (map1.equals(map2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }



    }

    @Test
    public void Test126() {
        for (int i = 0; i < 1; i++) {
            System.out.println("i = " + i);
        }

        System.out.println("===============分隔符===============");

        for (int i = 0; i < 1; ++i) {
            System.out.println("i = " + i);
        }


    }
}
