package com.experiment.algo.slidewindow;

import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-30 20:05
 * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
 * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
 * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,0,1,1,0,0]
 * 输出：1
 * 解释：这里列出一些能够将所有 1 聚集在一起的方案：
 * [0,0,1,1,1,0,0] 交换 1 次。
 * [0,1,1,1,0,0,0] 交换 1 次。
 * [1,1,0,0,0,0,1] 交换 2 次（利用数组的环形特性）。
 * 无法在交换 0 次的情况下将数组中的所有 1 聚集在一起。
 * 因此，需要的最少交换次数为 1 。
 *
 * 示例 2：
 *
 * 输入：nums = [0,1,1,1,0,0,1,1,0]
 * 输出：2
 * 解释：这里列出一些能够将所有 1 聚集在一起的方案：
 * [1,1,1,0,0,0,0,1,1] 交换 2 次（利用数组的环形特性）。
 * [1,1,1,1,1,0,0,0,0] 交换 2 次。
 * 无法在交换 0 次或 1 次的情况下将数组中的所有 1 聚集在一起。
 * 因此，需要的最少交换次数为 2 。
 *
 * 示例 3：
 *
 * 输入：nums = [1,1,0,0,1]
 * 输出：0
 * 解释：得益于数组的环形特性，所有的 1 已经聚集在一起。
 * 因此，需要的最少交换次数为 0 。
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 105
 *     nums[i] 为 0 或者 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeastSwitch {
    public int minSwaps(int[] nums) {
        int range = 0;
        int length = nums.length;
        for (int num : nums) {
            if (num == 1) {
                range ++;
            }
        }
        if (range <= 1 || range == length) {
            return 0;
        }

        int right, left;
        int ret = 0;
        for (right = 0; right < range; right++) {
            /** 已有的要尽量多找最大的*/
            ret += nums[right];
        }
        int finalRet = ret;

        for (left = 0; left < length; left++) {
            ret -= nums[left];
            ret += nums[right];

            finalRet = Math.max(finalRet, ret);

            if (right == length - 1) {
                right = 0;
            } else {
                right ++;
            }
        }
        return range - finalRet;

    }

    @Test
    public void Test87() {

        int[] nums = new int[]{1,1,1};
        System.out.println("minSwaps(nums) = " + minSwaps(nums));

    }
}
