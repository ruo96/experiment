package com.experiment.algo.ten10;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuruohong
 * @date 2022-05-28 9:48
 * 给定一个不包含重复数字的数组nums， 返回其所有可能的全排列，可以按照任意顺序
 * 例如： [0,1]   ===>   [0,1]  [1,0]
 */
public class Permute {
    
    public List<List<Integer>> allPath = new LinkedList<>();

    @Test
    public void Test17() {
        int[] nums = new int[]{1,2,3};
        System.out.println("permute(nums) = " + permute(nums));

    }

    public List<List<Integer>> permute(int[] nums) {
        //    当前路径，入口路径，path初始为空
        List<Integer> path = new LinkedList<>();
        backTrace(nums, path);
        return allPath;
        
    }

    private void backTrace(int[] nums, List<Integer> path) {

        // 表示走到了叶子节点了， 所以可以加入全排列组合了
        if (nums.length == path.size()) {
            allPath.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 这个是为了排查已经走过的路径
            if (path.contains(nums[i])) {
                continue;
            }
            // 做选择，加入当前路径
            path.add(nums[i]);
            // 递归， 进入下一层决策
            backTrace(nums, path);
            // 取消选择
            path.remove(path.size()-1);
        }
    }
}
