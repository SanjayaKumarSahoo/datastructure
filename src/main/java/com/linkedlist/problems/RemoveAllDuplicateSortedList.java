package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class RemoveAllDuplicateSortedList {
    public static void main(String[] args) {

        // 1->2->3->4->NULL
        SLLNode<Integer> one = new SLLNode<Integer>(1);
        SLLNode<Integer> two = new SLLNode<Integer>(2);
        SLLNode<Integer> three = new SLLNode<Integer>(3);
        SLLNode<Integer> four = new SLLNode<Integer>(3);
        SLLNode<Integer> five = new SLLNode<Integer>(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        removeAllDuplicateSortedList(one, 2);
        while (one != null) {
            System.out.println(one.data);
            one = one.next;
        }
    }


    // Let m be a positive integer and L a sorted singly linked list of integers.
    // For each integer k,if k appears more than m times in L,remove all nodes from L containing k.
    private static void removeAllDuplicateSortedList(SLLNode node, int k) {

        SLLNode current = node;
        SLLNode prev = null;
        SLLNode delete = null;
        int times = 0;

        while (current != null) {

            if (prev != null && prev.data == current.data) {
                times++;
            }

            if (times + 1 >= k) {
                delete.next = current.next;
                times = 0;
            }

            if (times == 0) {
                delete = prev;
            }

            prev = current;
            current = current.next;
        }
    }
}
