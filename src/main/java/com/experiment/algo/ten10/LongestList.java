package com.experiment.algo.ten10;

import com.experiment.algo.ten10.domain.ArrayData;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author wuruohong
 * @date 2022-05-27 21:34
 * 给定一个整数数组nums， 找到其中最长严格递增的子序列的长度  最好保存下来 todo
 * nums = [10,9,2,5,3,7,101,18]   结果就是4  子序列就是[2,3,7,101]
 */
public class LongestList {


    private int getLongestList(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        /** 首先找到边界情况*/
        dp[0] = 1;
        int maxans = 1;

        /** 开始从下往上遍历*/
        for (int i = 1; i < nums.length; i++) {
            /** 每次都给一个起始位置*/
            dp[i] = 1;
            /** 开始遍历子序列 从0到i开始遍历*/
            for (int j = 0; j < i; j++) {
                /** 如果可以找到前面比nums[i]小的数字nums[j]， 那么 dp[i] = dp[j] + 1  */
                if (nums[j] < nums[i]) {
                    /** 因为会有多个小于的， 所以会有多种组合，取最大放到dp[i]*/
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            /**  一轮之后，那么dp最大的那个就是nums最长子序列了*/
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;

    }

    @Test
    public void Test12() {
        int[] arr = ArrayData.getArrayData();
        System.out.println(Arrays.toString(arr));
//        Integer[] arr1 = new Integer[]{1,2,3,4};
//        System.out.println(Arrays.deepToString(arr1));

        System.out.println("getLongestList(arr) = " + getLongestList(arr));

        LongestPalindrome a = new LongestPalindrome();


    }
}
