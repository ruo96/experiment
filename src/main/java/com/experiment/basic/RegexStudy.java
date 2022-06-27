package com.experiment.basic;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuruohong
 * @date 2022-06-23 17:19
 */
public class RegexStudy {
    public static void main1(String[] args) {
        String regrex = "[0-9]+[a-z]+";
        String str = "123adf";
        System.out.println("str.matches(regrex) = " + str.matches(regrex));
        str = "abc123";
        System.out.println("str.matches(regrex) = " + str.matches(regrex));

        System.out.println("StringUtils.arrayToCommaDelimitedString(new String[]{\"a\",\"b\",\"c\"}) = " + StringUtils.arrayToCommaDelimitedString(new String[]{"a", "b", "c"}));

        regrex = "."; // 这个只匹配一个字符
        str = "A123";
        System.out.println("str.matches(regrex) = " + str.matches(regrex));

        regrex = "[^abc]";
        System.out.println("\"efa\".matches(regrex) = " + "efa".matches(regrex));
        System.out.println("\"jjj\".matches(regrex) = " + "jjj".matches(regrex));

        regrex = "abc*";
        System.out.println("\"abc\".matches(regrex) = " + "abc".matches(regrex));
        System.out.println("\"ab\".matches(regrex) = " + "ab".matches(regrex));
        System.out.println("\"abcccf\".matches(regrex) = " + "abcccf".matches(regrex));
        System.out.println("\"abccc\".matches(regrex) = " + "abccc".matches(regrex));

        // 校验手机号
        regrex = "1[3-9][0-9]{9}";
        System.out.println("\"13812345678\".matches(regrex) = " + "13812345678".matches(regrex));
        System.out.println("\"1381234567\".matches(regrex) = " + "1381234567".matches(regrex));
        System.out.println("\"117791238818283\".matches(regrex) = " + "117791238818283".matches(regrex));

        // 校验邮箱
        regrex = "^[a-zA-Z]+@[a-z0-9]+\\.(com)+$";
        // regrex = "^[A-Za-z0-9-_\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";  // $ 结尾位置
        System.out.println("\"1ab@163.com\".matches(regrex) = " + "1ab@163.com".matches(regrex));
        System.out.println("\"adfed@qq.com\".matches(regrex) = " + "adfed@qq.com".matches(regrex));
        System.out.println("\"adfed134@qq.com\".matches(regrex) = " + "adfed134@qq.com".matches(regrex));

        String word = " hello   world     realy  fast  ";
        for (String s : word.split("\\s+")) {
            System.out.println("s = " + s);
        }

        word = " hello  1world2   some66day";
        for (String s : word.trim().split("\\d+\\s*")) {
            System.out.println("s = " + s);

        }

    }

    public static void main(String[] args) {

        args = new String[]{"a2b==15&user==3"};
        Map<String, Integer> paramMap = new HashMap<>();
        if (args.length > 0) {
            System.out.println("传入参数 = " + Arrays.toString(args));
            String[] params = args[0].split("&+");
            for (String param : params) {
                String[] split = param.split("=+");
                if (split.length == 2) {
                    try {
                        paramMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (Exception e) {
                        System.out.println("参数 " + param + " 异常");
                    }
                }
            }
        } else {
            System.out.println("使用默认参数");
        }
        System.out.println("paramMap = " + paramMap);
    }
}
