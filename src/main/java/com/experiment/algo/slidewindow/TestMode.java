package com.experiment.algo.slidewindow;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-29 16:10
 * 这个部分主要用来总结有关滑动窗口的解题模式，希望能够不再对这类题感到束手无策
 */
public class TestMode {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    public double findMaxAverageV2(int[] nums, int k) {
        int left = 0;
        int right = k-1;
        int length = nums.length;

        int ret = 0;
        int moveResult = 0;
        int index = left;
        while (index <= right) {
            moveResult += nums[index++];
        }
        ret = moveResult;
        right++;

        while (right < length) {
            moveResult = moveResult + nums[right] - nums[left];
            if (nums[right] > nums[left]) {
                ret  = Math.max(moveResult , ret);
            }
            right++;
            left++;
        }

        return ret/(k*1.0);
    }

    public double findMaxAverageV3(int[] nums, int k) {
        int ret = 0;
        for (int i = 0; i < k; i++) {
            ret += nums[i];
        }

        int maxSum = ret;
        for (int i = k; i < nums.length ; i++) {
            ret = ret + nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, ret);
        }
        return 1.0 * maxSum / k;
    }

    @Test
    public void Test28() {
        //int[] nums = new int[]{1,12,-5,-6,50,3};
        int[] nums = new int[]{0,4,0,3,2};
        double maxAverage = findMaxAverage(nums, 1);
        System.out.println("maxAverage = " + maxAverage);


    }

    @Test
    public void Test48() {
        int a = 1234;
        double b = a /5.0;
        System.out.println("b = " + b);


    }


}
