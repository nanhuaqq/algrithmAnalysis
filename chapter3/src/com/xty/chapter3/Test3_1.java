package com.xty.chapter3;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/12/3 0003.
 */
public class Test3_1 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        Iterator iterator = myLinkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(myLinkedList.contains(1));
        System.out.println(myLinkedList.contains(5));
    }

    public static <AnyType> void printLots(List<AnyType> lList,List<Integer> pList){
        Iterator<AnyType> lIterator = (Iterator<AnyType>) lList.iterator();
        Iterator<Integer> pIterator = (Iterator<Integer>) pList.iterator();

        AnyType lItem = null;
        Integer pItem = null;

        int lIndex = -1;
        while(lIterator.hasNext() && pIterator.hasNext()){
            pItem = pIterator.next();

            while (lIndex < pItem && lIterator.hasNext()){
                lItem = lIterator.next();
                lIndex++;
            }

            System.out.println(lItem);
        }
    }

    /**
     * 3.4 solution
     * 给定俩个已排序的表L1和L2，只使用基本的表操作编写计算它们的交集L3
     */
    public static <AnyType extends Comparable> void intersection(MyLinkedList<AnyType> listOne,MyLinkedList<AnyType> listTwo,MyLinkedList<AnyType> interSectionList)
    {
        if (listOne.isEmpty() || listTwo.isEmpty()){
            return;
        }
        Iterator iteratorOne = listOne.iterator();
        Iterator iteratorTwo= listTwo.iterator();

        AnyType itemInOne = (AnyType) iteratorOne.next();
        AnyType itemInTwo = (AnyType) iteratorTwo.next();

        while (itemInOne != null && itemInTwo != null){

            int compareResult = itemInOne.compareTo(itemInTwo);

            if (compareResult < 0){ // itemInOne < itemInTwo
                itemInOne = iteratorOne.hasNext() ? (AnyType) iteratorOne.next() : null;
            }else if (compareResult == 0){
                interSectionList.add(itemInOne);
                itemInOne = iteratorOne.hasNext() ? (AnyType) iteratorOne.next() : null;
                itemInTwo = iteratorTwo.hasNext() ? (AnyType) iteratorTwo.next() : null;
            }else if (compareResult > 0){ // itemInOne > itemInTwo
                itemInTwo = iteratorTwo.hasNext() ? (AnyType) iteratorTwo.next() : null;
            }
        }
    }

    /**
     * 3.5 solution 给定已排序的表L1 L2    只使用基本的表操作 求它们的并集
     * @param listOne
     * @param listTwo
     * @param unionList
     * @param <AnyType>
     */
    public static <AnyType extends Comparable> void union(MyLinkedList<AnyType> listOne,MyLinkedList<AnyType> listTwo,MyLinkedList<AnyType> unionList){
        Iterator iteratorOne = listOne.iterator();
        Iterator iteratorTwo = listTwo.iterator();

        AnyType itemInOne = (AnyType) iteratorOne.next();
        AnyType itemInTwo = (AnyType) iteratorTwo.next();

        while (itemInOne != null && itemInTwo != null){
            int compareResult = itemInOne.compareTo(itemInTwo);
            if (compareResult == 0){
                unionList.add(itemInOne);
                itemInOne = iteratorOne.hasNext() ? (AnyType) iteratorOne.next() : null;
                itemInTwo = iteratorTwo.hasNext() ? (AnyType) iteratorTwo.next() : null;
            }else if (compareResult < 0){
                unionList.add(itemInOne);
                itemInOne = iteratorOne.hasNext() ? (AnyType) iteratorOne.next() : null;
            }else if (compareResult > 0){
                unionList.add(itemInTwo);
                itemInTwo = iteratorTwo.hasNext() ? (AnyType) iteratorTwo.next() : null;
            }
        }

        if (itemInOne == null && itemInTwo != null){
            unionList.add(itemInTwo);
            while (iteratorTwo.hasNext()){
                unionList.add((AnyType) iteratorTwo.next());
            }
        }

        if (itemInTwo == null && itemInOne != null){
            unionList.add(itemInOne);
            while (iteratorOne.hasNext()){
                unionList.add((AnyType) iteratorOne.next());
            }
        }
    }
}
