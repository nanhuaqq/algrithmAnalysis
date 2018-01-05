package com.xty.qq;

/**
 * Created by Administrator on 2018/1/5 0005.
 */
public class BubbleSort {

    public static void bubbleSort(int [] sourceArray){
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
                if (sourceArray[i] > sourceArray[i+1]){
                    isSwap = true;
                    int t = sourceArray[i];
                    sourceArray[i] = sourceArray[i+1];
                    sourceArray[i+1] = t;
                }
            }
            needSortLen --;
        }
    }

    public static void main(String[] args) {
        int [] sourceArray = {10,9,8,7,6,5,4,3,2,1};
        bubbleSort(sourceArray);

        for (int i = 0; i < sourceArray.length; i++) {
            System.out.println(sourceArray[i]);
        }
    }
}
