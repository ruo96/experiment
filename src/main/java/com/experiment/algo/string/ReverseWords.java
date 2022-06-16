package com.experiment.algo.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wuruohong
 * @date 2022-06-15 20:14
 */
public class ReverseWords {

    @Test
    public void Test13() {
        String str = "  hello   world   ";
        System.out.println("reverseWordsM(str) = " + reverseWordsM(str));

    }

    private String reverseWordsM(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    @Test
    public void Test32() {
        String s = "  hello  1   world ";
        s = s.trim();
        System.out.println("s = " + s);


        String[] split = s.split("\\d+\\s+");

        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
    }

    private String reverseWordsMV2(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }


}
