package com.experiment.algo.sort;

import java.util.Arrays;

/**
 * @author wuruohong
 * @date 2022-06-24 11:07
 */
public class FastSort {


    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,0,1,5,8};
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        int l = 0;
        int r = arr.length - 1;
        quick(arr, l, r);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void quick(int[] arr, int l, int r) {
        if (l < r) {
            int p = getP(arr, l, r);
            quick(arr, l, p - 1);
            quick(arr, p + 1, r);
        }
    }

    private static int getP(int[] arr, int l, int r) {
        int base = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= base) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= base) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = base;
        return l;
    }


}
