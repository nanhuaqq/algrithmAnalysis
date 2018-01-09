package com.xty.qq;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
public class QuickSort2Way {

    public static <T extends Comparable<T>> void sort(Comparable<T>[] arr){
        if (arr == null){
            throw new NullPointerException();
        }
        int len = arr.length;
        sort(arr,0,len-1);
    }

    public static <T extends Comparable<T>> void sort(Comparable<T> [] arr, int l, int r){
        if (l >= r){
            return;
        }
        int j = partition(arr,l,r);
        sort(arr,l,j -1);
        sort(arr, j+1,r);

    }

    public static <T extends Comparable<T>> int partition(Comparable<T>[] arr, int l , int r){
        int i = l+1;
        int j = r;
        T v = (T) arr[l];
        while (true){
            while (i <= r && arr[i].compareTo(v) < 0){
                i++;
            }
            while (j >= l+1 && arr[j].compareTo(v) > 0){
                j--;
            }
            if (i >= j){
                break;
            }
            SelectionSort.swap(arr,i,j);
            i++;
            j--;
        }

        try {
            SelectionSort.swap(arr, l, j);
        }catch (Exception e){
            System.out.println("i=>"+i);
            System.out.println("l=>"+l);
            System.out.println("j=>"+j);
        }
        return j;
    }

    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xty.qq.QuickSort2Way", arr);

        return;
    }
}
