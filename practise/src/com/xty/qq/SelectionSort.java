package com.xty.qq;

/**
 * Created by Administrator on 2018/1/5 0005.
 */
public class SelectionSort {

    public static void selectionSort(int[] sourceArray){
        if (sourceArray ==  null || sourceArray.length <= 1){
            return;
        }
        int len = sourceArray.length;
        for (int i = 0; i < len; i++) {

            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (sourceArray[j] < sourceArray[minIndex]){
                    minIndex = j;
                }
            }
            swap(sourceArray, i, minIndex);
        }
    }

    public  static  void swap(int [] sourceArray, int i, int j){
        if (sourceArray == null){
            throw new NullPointerException();
        }
        int len = sourceArray.length;
        if (i >= len || j >= len){
            throw new IndexOutOfBoundsException();
        }

        if (i == j){
            return;
        }

        int temp = sourceArray[i];
        sourceArray[i] = sourceArray[j];
        sourceArray[j] = temp;
    }

    public static void main(String[] args) {
        int [] sourceArray = {10,9,8,7,6,5,4,3,2,1};
        selectionSort(sourceArray);

        for (int num :
                sourceArray) {
            System.out.println(num);
        }
    }
}
