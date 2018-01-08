package com.xty.qq;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/1/6 0006.
 */
public class SortTestHelper {

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        if (rangeL >= rangeR){
            return null;
        }

        Integer [] arr = new Integer[n];
        for (int i = 0; i < n; i++){
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }

        return arr;
    }

    // 打印arr数组的所有内容
    public static void printArray(Object arr[]) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }

    public static boolean isSorted(Comparable[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0){
                return false;
            }
        }
        return true;
    }

    //测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行的时间
    public static void testSort(String sortClassName,Comparable[] arr){
        testSort(sortClassName,"sort",arr);
    }

    public static void testSort(String sortClassName,String methodName,Comparable[] arr){
        try {
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod(methodName,new Class[]{Comparable[].class});
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            if (!isSorted( arr )){
                System.out.println("error");
            }
            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
