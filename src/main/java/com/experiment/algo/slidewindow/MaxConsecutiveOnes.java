package com.experiment.algo.slidewindow;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-30 12:53
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 *
 *
 * 提示：
 *     1 <= nums.length <= 105
 *     nums[i] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int left=0, right;
        int result = 0;
        int length = nums.length;
        int ret = 0;

        for (right = 0; right < length; right++) {

            result += nums[right];

            if (nums[right] == 1) {
                ret = Math.max(ret, result);
            }

            if (result != right - left + 1 && right < length - 1) {
                result = 0;
                left = right + 1;
            }
        }
        return ret;
    }

    public int findMaxConsecutiveOnesV2(int[] nums) {
        int maxCount = 0, count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    @Test
    public void Test52() {
        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println("findMaxConsecutiveOnes(nums) = " + findMaxConsecutiveOnesV2(nums));

    }
}
