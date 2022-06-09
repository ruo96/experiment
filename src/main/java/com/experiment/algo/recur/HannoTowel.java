package com.experiment.algo.recur;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuruohong
 * @date 2022-06-09 9:12
 */
public class HannoTowel {

    @Test
    public void Test12() {
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(3);
        a.add(2);

        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();

        hannota(a,b,c);
        System.out.println("c = " + c);

    }

    public void hannota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hannoMove(A.size(), A, B, C);
    }

    private void hannoMove(int size, List<Integer> a, List<Integer> b, List<Integer> c) {
        if (size==1) {
            c.add(a.remove(a.size()-1));
            System.out.println("c = " + c);
            return;
        }

        hannoMove(size - 1, a, c, b);
        c.add(a.remove(a.size()-1));
        System.out.println("c = " + c);
        hannoMove(size - 1, b, a, c);
    }


}
