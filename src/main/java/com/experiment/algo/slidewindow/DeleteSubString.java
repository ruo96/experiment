package com.experiment.algo.slidewindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuruohong
 * @date 2022-05-30 1:55
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 * 示例 1：
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]

 */
public class DeleteSubString {

    @Test
    public void Test19() {
        int[] nums = new int[]{187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
        nums = new int[]{187,470,25,436,538,809,

                441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,
                340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434};
        System.out.println("maximumUniqueSubarray(nums) = " + maximumUniqueSubarray(nums));
        System.out.println("maximumUniqueSubarrayv2(nums) = " + maximumUniqueSubarrayV2(nums));


    }
    public int maximumUniqueSubarray(int[] nums) {
        int right, left = 0;
        Set<Integer> set = new HashSet<>();

        int ret = 0;
        int maxSum = 0;

        for (right = 0; right < nums.length; right++) {
            int c = nums[right];
            ret += c;
            //System.out.println("ret = " + ret + " c = " + c);

            while (set.contains(c)) {
                ret -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(c);
            maxSum = Math.max(ret, maxSum);
        }
        return maxSum;
    }

    public int maximumUniqueSubarrayV2(int[] nums) {
        int right, left = 0;
        Map<Integer,  Integer> set = new HashMap<>();

        int ret = 0;
        int maxSum = 0;
        int dex;

        for (right = 0; right < nums.length; right++) {
            int c = nums[right];
            ret += c;

            if (set.containsKey(c)) {
                dex = set.get(c);
                while (left <= dex) {
                    ret -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
            }
            set.put(c, right);
            maxSum = Math.max(ret, maxSum);
        }
        return maxSum;
    }

    @Test
    public void Test58() {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            set.add(i);
            set.contains(i+1);
        }
        long s2 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            map.put(i,1);
            map.containsKey(i+1);
        }
        long s3 = System.currentTimeMillis();

        System.out.println("s2-s1 = " + (s2 - s1));
        System.out.println("s3-s2 = " + (s3 - s2));

    }
}
