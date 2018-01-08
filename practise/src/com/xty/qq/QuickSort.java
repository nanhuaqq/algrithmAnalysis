package com.xty.qq;

/**
 * Created by Administrator on 2018/1/8 0008.
 */
public class QuickSort {

    public static <T extends Comparable<T>> void sort(Comparable<T> [] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    public static<T extends Comparable<T>> int partition(Comparable<T> [] arr,int l, int r){
        int i = l+1;
        int j = l;
        for (; i <= r; i++){

            if (arr[l].compareTo((T) arr[i]) >= 0){
                SelectionSort.swap(arr,j+1,i);
                j++;
            }
        }
        SelectionSort.swap(arr,l,j);


        return j;
    }

    public static<T extends Comparable<T>> void sort(Comparable<T> [] arr, int l, int r){
        if (l >= r){
            return;
        }

        int p = partition(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xty.qq.QuickSort", arr);

        return;
    }
}
