package com.xty.qq;

/**
 * Created by Administrator on 2018/1/8 0008.
 */
public class MergeSortBottomUp {

    public static <T extends Comparable<T>> void sort(Comparable<T>[] arr) {
        int len = arr.length;
        for (int sz = 1; sz < len; sz *= 2) {

            for (int i = 0; i + sz < len; i += 2 * sz) {
                MergeSort.merge(arr, i, i + sz - 1, Math.min(i + 2 * sz - 1, len - 1));
            }
        }
    }

    // 测试 MergeSort BU
    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        // 关于这部分陷阱，推荐看我的《玩转算法面试》课程，第二章：《面试中的复杂度分析》：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.xty.qq.MergeSortBottomUp", arr);

        return;
    }
}
