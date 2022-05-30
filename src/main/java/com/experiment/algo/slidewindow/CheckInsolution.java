package com.experiment.algo.slidewindow;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wuruohong
 * @date 2022-05-30 12:15
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 示例 1：
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 *
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     1 <= s1.length, s2.length <= 104
 *     s1 和 s2 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckInsolution {
    @Test
    public void Test32() {
        String s1 ="ab";
        String s2 ="aeidbaooob";
        //System.out.println("checkInclusion(s1,s2) = " + checkInclusion(s1, s2));

        s2 ="eibaooo";
        System.out.println("checkInclusion(s1,s2) = " + checkInclusion(s1, s2));

    }

    public boolean checkInclusion(String s1, String s2) {

        int diff = s2.length() - s1.length();
        if (diff <0) {
            return false;
        }

        int[] s = new int[26];
        int[] t = new int[26];

        int sLen = s1.length();
        int lLen = s2.length();

        for (int i = 0; i < sLen; ++i) {
            ++t[s1.charAt(i) -'a'];
            ++s[s2.charAt(i) -'a'];
        }

        if (Arrays.equals(s, t)) {
            return true;
        }

        for (int i = 0; i < diff; i++) {
            --s[s2.charAt(i) - 'a'];
            ++s[s2.charAt(i + sLen) - 'a'];
            if (Arrays.equals(s, t)) {
                return true;
            }
        }
        return false;

    }
}
