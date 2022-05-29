package com.experiment.algo.slidewindow;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-30 1:27
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。

 */
public class ShortestSubstring {

    @Test
    public void Test18() {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println("minSubArrayLen(target, nums) = " + minSubArrayLen(target, nums));

    }

    public int minSubArrayLen(int target, int[] nums) {
        int left=0, right ;
        int minLength = Integer.MAX_VALUE;
        int result = 0;
        for (right = 0; right < nums.length; right++) {
            result += nums[right];
            if (result >= target) {
                minLength = Math.min(minLength, right - left + 1);
                System.out.println("right = " + right+ " left = " + left);
            }
            while (result >= target) {
                minLength = Math.min(minLength, right - left + 1);
                result -= nums[left];
                left ++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

    public int anotherMethod(int target, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= target) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
