package com.qq.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {



     /**
     *  * Definition for singly-linked list.
     *  * public class ListNode {
     *  *     int val;
     *  *     ListNode next;
     *  *     ListNode(int x) { val = x; }
     *  * }
     *  */
    public static class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverseNode(ListNode l){
        ListNode currentNode = l;
        ListNode nextNode = currentNode.next;
        currentNode.next = null;
        while(nextNode != null){
            ListNode tmpNode = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = tmpNode;
        }
        return currentNode;
    }

    public static int size(ListNode l){
        if(l == null){
            return 0;
        }
        int size = 1;
        while(l.next != null){
            size++;
            l = l.next;
        }
        return size;
    }

    public static void printListNode(ListNode node){
        if (node == null) {
            System.out.println();
            return;
        }
        System.out.print("=>");
        System.out.print(node.value);
        printListNode(node.next);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sizeOne = size(l1);
        int sizeTwo = size(l2);

        ListNode listOne = l1;
        ListNode listTwo = l2;
        int jinwei = 0;
        int modValue = 0;
        ListNode listNew, tmpNode;
        if(sizeOne >= sizeTwo){
            listNew = listOne;
            tmpNode = listOne;
        } else {
            listNew = listTwo;
            tmpNode = listTwo;
        }
        ListNode zeroNode = new ListNode(0);
        while (listNew != null){
            if(listOne == null){
                listOne = zeroNode;
            }
            if(listTwo == null){
                listTwo = zeroNode;
            }
            modValue=(listOne.value + listTwo.value)%10;
            int tmpJw = (listOne.value + listTwo.value)/10;
            if (jinwei + modValue < 10){
                listNew.value = jinwei + modValue;
                jinwei = tmpJw;
            } else {
                listNew.value = (jinwei + modValue) % 10;
                jinwei = 1;
            }


            listOne = listOne.next;
            listTwo = listTwo.next;

            //特殊情况考虑
            if(listNew.next == null && jinwei > 0){
                ListNode lastNode = new ListNode(jinwei);
                listNew.next = lastNode;
                break;
            } else {
                listNew = listNew.next;
            }
        }
        return tmpNode;
    }
}
