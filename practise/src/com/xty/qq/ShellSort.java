package com.xty.qq;

/**
 * Created by Administrator on 2018/1/7 0007.
 */
public class ShellSort {

    public static<T extends Comparable<T>> void sort(Comparable<T> [] arr){
        if (arr == null){
            throw new NullPointerException();
        }

        int len = arr.length;
        if (len <= 1){
            return;
        }

        int h = 1;

        while (h < len/3){
            h = 3 * h + 1;
        }

        while (h >= 1){
            for (int i = 0; i < len; i++) {
                int j = i;
                Comparable temp = arr[i];
                for (; j >= h && temp.compareTo((T) arr[j-h]) < 0 ; j-=h) {
                    arr[j] = arr[j-h];
                }
                arr[j] = temp;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 200000;
        Integer[] sourceArray = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("com.xty.qq.InsertSort", sourceArray);

        SortTestHelper.testSort("com.xty.qq.ShellSort","sort", sourceArray);
    }
}
