package com.xty.qq;

/**
 * Created by Administrator on 2018/1/6 0006.
 */
public class InsertSort {

    public static<T extends Comparable<T>> void sort(T[] arr){
        if (arr == null){
            throw new NullPointerException();
        }
        int len = arr.length;
        if (len <= 1){
            return;
        }

        for (int i = 1; i < len; i++) {

            for (int j = i; j > 0 ; j--) {
                if (arr[j].compareTo(arr[j-1]) < 0){
                    SelectionSort.swap(arr,j,j-1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void insertPartSortTest(Comparable<T> [] arr){
        insertPartSort(arr,0,arr.length -1);
    }

    public static <T extends Comparable<T>> void insertPartSort(Comparable<T> [] arr,int l, int r){
        assert l >= 0 && l <= r && r < arr.length;

        for( int i = l ; i <= r ; i ++ ){
            Comparable e = arr[i];
            int j = i;
            for(; j > l && arr[j-1].compareTo((T) e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    public static<T extends Comparable<T>> void betterInsertSort(Comparable[] arr){
        if (arr == null){
            throw new NullPointerException();
        }
        int len = arr.length;
        if (len <= 1){
            return;
        }

        for (int i = 0; i < len; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 ; j--) {
                if (arr[j-1].compareTo(temp) > 0){
                    //移动数组位置 从j+1 到 i
                    arr[j] = arr[j -1];
                }else {
                    break;
                }
            }
            arr[j] = temp;
//            Comparable e = arr[i];
//            int j = i;
//            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
//                arr[j] = arr[j-1];
//            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 200000;
        Integer[] sourceArray = SortTestHelper.generateRandomArray(N, 0, 1000000);
//        SortTestHelper.testSort("com.xty.qq.InsertSort", sourceArray);

        SortTestHelper.testSort("com.xty.qq.InsertSort","betterInsertSort", sourceArray);
    }
}
