package com.qq.leetcode;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AddTwoNumbersTest {
    private AddTwoNumbers.ListNode list;
    private AddTwoNumbers.ListNode list243;
    private AddTwoNumbers.ListNode list564;

    @Before
    public void init(){
        //    1  2   3
        AddTwoNumbers.ListNode nodeOne = new AddTwoNumbers.ListNode(1);
        AddTwoNumbers.ListNode nodeTwo = new AddTwoNumbers.ListNode(2);
        AddTwoNumbers.ListNode nodeThree = new AddTwoNumbers.ListNode(3);
        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        list = nodeOne;

        AddTwoNumbers.ListNode list243Two = new AddTwoNumbers.ListNode(2);
        AddTwoNumbers.ListNode list243Four = new AddTwoNumbers.ListNode(4);
        AddTwoNumbers.ListNode list243Three = new AddTwoNumbers.ListNode(3);
        list243 = list243Two;
        list243.next = list243Four;
        list243Four.next = list243Three;

        AddTwoNumbers.ListNode list564Five = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode list564Six = new AddTwoNumbers.ListNode(6);
        AddTwoNumbers.ListNode list564Four = new AddTwoNumbers.ListNode(4);
        list564 = list564Five;
        list564.next = list564Six;
        list564Six.next = list564Four;
    }

    @Test
    public void testPrint(){
        System.out.println("testPrint");
        AddTwoNumbers.printListNode(list);
    }

    @Test
    public void testReverse(){
        System.out.println("test reverse");
        AddTwoNumbers.printListNode(AddTwoNumbers.reverseNode(list));
    }

    @Test
    public void testAddTwoNumbers(){
        System.out.println("test add two numbers");
        AddTwoNumbers.printListNode(list243);
        AddTwoNumbers.printListNode(list564);
        AddTwoNumbers.ListNode addtowNumbersNode = AddTwoNumbers.addTwoNumbers(list243, list564);
        AddTwoNumbers.printListNode(addtowNumbersNode);

        AddTwoNumbers.ListNode nodeFive = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode node5 = new AddTwoNumbers.ListNode(5);

        AddTwoNumbers.ListNode node = AddTwoNumbers.addTwoNumbers(node5, nodeFive);
        AddTwoNumbers.printListNode(node);
    }
}
