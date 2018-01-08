package com.xty.qq;

/**
 * Created by Administrator on 2018/1/5 0005.
 */
public class SelectionSort {

    public static<T extends Comparable<T>> void sort(T[]  sourceArray){
        if (sourceArray ==  null || sourceArray.length <= 1){
            return;
        }
        int len = sourceArray.length;
        for (int i = 0; i < len; i++) {

            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (sourceArray[j].compareTo(sourceArray[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(sourceArray, i, minIndex);
        }
    }

    public  static  void swap(Object[] sourceArray, int i, int j){
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

        Object temp = sourceArray[i];
        sourceArray[i] = sourceArray[j];
        sourceArray[j] = temp;
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] sourceArray = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xty.qq.SelectionSort", sourceArray);
    }
}
