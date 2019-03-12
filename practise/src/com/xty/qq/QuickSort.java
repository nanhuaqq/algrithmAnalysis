package com.xty.qq;

/**
 * Created by Administrator on 2018/1/8 0008.
 */
public class QuickSort {

    public static <T extends Comparable<T>> void quickSort(Comparable<T>[] arr) {
        printArray(arr);
        int partition = partion2( arr,0, arr.length - 1);
        if (partition - 1 > 0) {
            partion2(arr, 0, partition - 1);
        }
        if (partition + 1 < arr.length - 1) {
            partion2(arr, partition + 1, arr.length -1);
        }

        printArray(arr);

    }

    private  static  void printArray(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    public static <T extends Comparable<T>> int partion2(Comparable[] arr, int l, int r) {
        Comparable base = arr[l];
        int begin = l;
        int end = r;

        while (begin < end) {

            while (arr[end].compareTo(base) >= 0 && begin < end) {
                end --;
            }

            Comparable tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;


            while (arr[begin].compareTo(base) < 0 && begin < end) {
                begin ++;
            }

            tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;

        }

        arr[begin] = base;

        return begin;
    }

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
        int N = 10000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        Integer[] arr = new Integer[] {7,2,1,1};
        SortTestHelper.testSort("com.xty.qq.QuickSort","quickSort", arr);

        return;
    }
}
