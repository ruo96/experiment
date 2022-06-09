package com.experiment.algo.other;

import com.experiment.algo.ten10.LongestPalindrome;
import org.junit.Test;

/**
 * @author wuruohong
 * @date 2022-05-28 0:04
 */
public class TestPublic {

    /**
     * public private, protected,不写default
     *
     * 修饰符       当前类     同包      子类       其他包
     * public       y         y        y          y
     * protected    y         y        y          n
     * default      y         y        n          n
     * private      y         n        n          n
     */
    @Test
    public void Test10() {
        LongestPalindrome a = new LongestPalindrome();
        System.out.println("a.s = " + a.s);
//        System.out.println("a.s1 = " + a.s1);


    }

    @Test
    public void Test31() {
        int x = -1,  y =2;
        int a = x^y;
        System.out.println("a = " + a);

    }
}
