package com.xty.chapter3;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
public class IntersectionTest {
    private MyLinkedList<Integer> listOne,listTwo,intersectionList,unionList;

    @Before
    public void setup(){
        listOne = new MyLinkedList<>();
        listTwo = new MyLinkedList<>();
        intersectionList = new MyLinkedList<>();
        unionList = new MyLinkedList<>();
        listOne.add(1);
        listOne.add(3);
        listOne.add(5);
        listOne.add(7);
        listOne.add(9);

        listTwo.add(2);
        listTwo.add(4);
        listTwo.add(5);
        listTwo.add(8);
        listTwo.add(9);
    }

    @Test
    public void testIntersection(){
        Test3_1.intersection(listOne,listTwo,intersectionList);
        Assert.assertEquals(intersectionList.size(),2);
        Assert.assertTrue(intersectionList.contains(5) && intersectionList.contains(9));
    }

    @Test
    public void testUnion(){
        Test3_1.union(listOne,listTwo,unionList);
        Assert.assertEquals(unionList.size(),8);
        Assert.assertTrue(unionList.contains(1) && unionList.contains(2) && unionList.contains(3) && unionList.contains(4) && unionList.contains(5)
         && unionList.contains(7) && unionList.contains(8) && unionList.contains(9));
    }
}
