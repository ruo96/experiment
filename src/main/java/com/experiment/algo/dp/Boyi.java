package com.experiment.algo.dp;

/**
 * @author wuruohong
 * @date 2022-06-08 0:21
 */
public class Boyi {

    class Pair{
        int fir, sec;

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

    public int stoneGame(int[] piles) {
        int n = piles.length;
        // 初始化dp数组
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        // 开始填入base
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        // 开始斜着遍历数组
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n-1 ; i++) {
                int j = i + l - 1;
                // 开始分别计算最左边或者最右边的分数
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].fir;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }

            }
        }
        Pair res = dp[0][n-1];
        return res.fir - res.sec;
    }
}
