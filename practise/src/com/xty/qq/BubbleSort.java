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

    public static void main(String[] args) {
        int N = 20000;
        Integer[] sourceArray = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xty.qq.BubbleSort","bubbleSort",sourceArray);
    }
}
