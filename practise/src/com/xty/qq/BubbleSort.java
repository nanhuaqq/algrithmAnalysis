package com.xty.qq;

/**
 * Created by Administrator on 2018/1/5 0005.
 */
public class BubbleSort {

    public static<T extends Comparable<T>> void bubbleSort(Comparable[] sourceArray){
        if (sourceArray == null){
            throw  new NullPointerException();
        }
        int len = sourceArray.length;
        if (len <= 1){
            return;
        }

        boolean isSwap = true;

        int needSortLen = len;

        while (isSwap){
            isSwap = false;
            for (int i = 0; i < needSortLen - 1; i++) {
                if (sourceArray[i] .compareTo( sourceArray[i+1]) > 0){
                    isSwap = true;
                    Comparable t = sourceArray[i];
                    sourceArray[i] = sourceArray[i+1];
                    sourceArray[i+1] = t;
                }
            }
            needSortLen --;
        }
    }

    public static <T extends Comparable<T>> void bubbleSort2(Comparable[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        }

        int len = arr.length;
        if (len <= 1) {
            return;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i -1 ; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] sourceArray = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xty.qq.BubbleSort","bubbleSort2",sourceArray);
    }
}
