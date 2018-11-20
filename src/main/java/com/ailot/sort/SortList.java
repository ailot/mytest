package com.ailot.sort;

import java.util.Arrays;

public class SortList {

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 6, 3, 16, 7, 11};
        //bubbleSort(a);
        //quickSort(a, 0, a.length - 1);
        selectSort(a);
        System.out.println(Arrays.toString(a));


    }

    private static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }


    private static int[] quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int temp = a[left];
            int t;
            while (j > i && a[j] >= temp) {
                j--;
            }
            while (i < j && a[i] <= temp) {
                i++;
            }
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
            a[left] = a[i];
            a[i] = temp;
            //完成一轮分区，已经将区域划分去左右两个分区，执行递归，对分区继续操作
            quickSort(a, left, i - 1);
            quickSort(a, j + 1, right);
        }
        return a;
    }


    private static int[] selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }

}
