package com.experiment.algo.sum;

import org.junit.Test;

import java.util.*;

/**
 * @author wuruohong
 * @date 2022-05-30 21:38
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 *
 * 提示：
 *
 *     0 <= nums.length <= 3000
 *     -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if (nums[i] > 0) {
                return lists;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    lists.add(Arrays.asList(curr, nums[L], nums[R]));
                    // 去除重复项
                    while (L < R && nums[L + 1] == nums[L]){
                        ++L;
                    }
                    while (L < R && nums[R-1] == nums[R]){
                        --R;
                    }
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;

    }
    @Test
    public void Test58() {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println("threeSum(num) = " + threeSum(nums));


    }
}
