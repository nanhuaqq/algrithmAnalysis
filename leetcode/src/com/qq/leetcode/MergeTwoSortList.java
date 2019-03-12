package com.qq.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortList {

    public ListNode mergeTwoLists(ListNode listOne, ListNode listTwo) {
        if(listOne == null){
            return listTwo;
        }
        if(listTwo == null){
            return listOne;
        }

        ListNode newList = new ListNode(0);
        if (listOne.val < listTwo.val) {
            newList.next = listOne;
            listOne = listOne.next;
        } else {
            newList.next = listTwo;
            listTwo = listTwo.next;
        }
        while (listOne != null && listTwo != null) {
            while ( listOne.next != null && listOne.next.val < listTwo.val) {
                listOne = listOne.next;
            }
            while ( listTwo.next != null && listOne.next.val >= listTwo.val ) {
                listTwo = listTwo.next;
            }
            if (listOne.val < listTwo.val) {
                ListNode tmpNode = listOne.next;
                listOne.next = listTwo;
                listOne = tmpNode;
            } else {
                ListNode tmpNode = listTwo.next;
                listTwo.next = listOne;
                listTwo = tmpNode;
            }
        }
        return newList.next;
    }

    public static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listOne = new ListNode(1);
        listOne.next = new ListNode(2);
        listOne.next.next = new ListNode(4);

        ListNode listTwo = new ListNode(1);
        listTwo.next = new ListNode(3);
        listTwo.next.next = new ListNode(4);

        MergeTwoSortList solution = new MergeTwoSortList();
        solution.printlnNode(listOne);

        solution.printlnNode(listTwo);

        ListNode resultNode = solution.mergeTwoLists(listOne, listTwo);
        solution.printlnNode(resultNode);
    }

    public void printlnNode(ListNode node) {
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
        System.out.println("---------------");
    }
}
