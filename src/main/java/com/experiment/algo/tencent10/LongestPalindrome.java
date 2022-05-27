package com.experiment.algo.tencent10;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-27 23:58
 * 找到最长的回文字符串  给一个字符串，找到其中最长的回文子串
 */
public class LongestPalindrome {

    public String s = "abcdedc";

    private String s1 = "123";

    @Test
    public void Test15() {
        String str = "babad";

        String result = getLongestPalindrome(str);
        System.out.println("result = " + result);
    }

    private String getLongestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String r1  = subLongestPalindrome(s, i, i);
            String r2  = subLongestPalindrome(s, i, i+1);
            String tempMax = r1.length() > r2.length() ? r1 : r2;
            result = tempMax.length() > result.length() ? tempMax : result;
        }
        return result;
    }

    private String subLongestPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }


}
