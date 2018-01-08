package com.xty.qq;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/7 0007.
 */
public class MergeSort {

    public static <T extends Comparable<T>> void sort(Comparable<T>[] arr) {
        if (arr == null){
            throw new NullPointerException();
        }
        int len = arr.length;
        sort(arr,0,len -1);
    }

    public static <T extends Comparable<T>> void sort(Comparable<T>[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static <T extends Comparable<T>> void merge(Comparable<T>[] arr, int l, int mid, int r) {

        Comparable<T> [] aux = Arrays.copyOfRange(arr,l,r+1);
//
        int i = l,j= mid +1;
        for (int k = l; k <= r; k++){

            if (i > mid ){ //判断左半部分下标是否越界
                arr[k] = aux[j - l];
                j++;
            }else if (j > r ){ //判断右半部分下标是否越界
                arr[k] = aux[i - l];
                i++;
            }else if (aux[i - l].compareTo((T) aux[j - l]) < 0 ){
                arr[k] = aux[i - l];
                i++;
            }else{
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 200000;
        Integer[] sourceArray = SortTestHelper.generateRandomArray(N, 0, 100000);

        SortTestHelper.testSort("com.xty.qq.MergeSort","sort", sourceArray);
    }
}
