package com.experiment.algo.dp;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-06-06 0:17
 */
public class change2 {

    public int change2Method(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        /*for (int i = 0; i < amount; i++) {
            dp[0][i] = 0;
        }*/
        // dp[n][m] 代表使用前n个钱进行组合得到m元的时候，总共的方法是多少
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount ; j++) {
                if (j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    public int change2MethodV2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // dp[n][m] 代表使用前n个钱进行组合得到m元的时候，总共的方法是多少
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount ; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public int change2MethodV3(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    @Test
    public void Test14() {
        int amount = 5;
        int[] coins = new int[]{5,1,2};
        //System.out.println("change2Method(amount, coins) = " + change2Method(amount, coins));
        System.out.println("change2MethodV3(amount, coins) = " + change2MethodV3(amount, coins));


    }
}
