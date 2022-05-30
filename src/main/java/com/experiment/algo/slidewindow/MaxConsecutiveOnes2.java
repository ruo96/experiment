package com.experiment.algo.slidewindow;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-30 12:53
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 提示：
 *
 *     1 <= nums.length <= 105
 *     nums[i] 不是 0 就是 1
 *     0 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxConsecutiveOnes2 {

    public int longestOnes(int[] nums, int k) {
        int right=0, left = 0;
        int result = 0;
        int maxCount = 0;

        for (right = 0; right < nums.length; right++) {
            result += nums[right];

            if (result + k > right - left) {
                maxCount = Math.max(maxCount, right - left+1);
            }

            while (result + k <= right - left) {
                result -= nums[left++];
            }
        }
        return maxCount;
    }

    public int longestOnesV2(int[] nums, int k) {
        int n = nums.length;
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for (int right = 0; right < n; ++right) {
            rsum += 1 - nums[right];
            while (lsum < rsum - k) {
                lsum += 1 - nums[left];
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    @Test
    public void Test60() {
        int[] nums = new int[]{1,1,0,0,0,1,1,1,0,1};
        int k = 2;
        System.out.println("longestOnes(nums, k) = " + longestOnes(nums, k));

    }



    @Test
    public void Test52() {
        int[] nums = new int[]{1,1,0,1,1,1};

    }
}
