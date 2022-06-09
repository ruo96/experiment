package com.experiment.algo.dp;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-06-07 16:35
 */
public class LongestCommonSubsequence {
    @Test
    public void Test9() {
        String s1 = "acf";
        String s2 = "wodewodebcdegf";
        System.out.println("getLongest(s1, s2) = " + getLongest(s1, s2));
        System.out.println("getLongestv2(s1, s2) = " + getLongestV2(s1, s2));

    }
    public int getLongest(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        return getResult(l1-1, l2-1, s1, s2);
    }

    private int getResult(int i, int j, String s1, String s2) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return getResult(i - 1, j - 1, s1, s2) + 1;
        } else {
            return Math.max(getResult(i - 1, j, s1, s2), getResult(i, j - 1, s1, s2));
        }
    }


    public int getLongestV2(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        // 初始化完毕
        for (int i = 0; i < l1+1; i++) {
            for (int j = 0; j < l2+1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[l1][l2];
    }
}
