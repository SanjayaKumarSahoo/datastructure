package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class RemoveDuplicateSortedList {
    public static void main(String[] args) {

        // 1->2->3->4->NULL
        SLLNode<Integer> one = new SLLNode<Integer>(1);
        SLLNode<Integer> two = new SLLNode<Integer>(1);
        SLLNode<Integer> three = new SLLNode<Integer>(2);
        SLLNode<Integer> four = new SLLNode<Integer>(1);
        SLLNode<Integer> five = new SLLNode<Integer>(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        removeDuplicateSortedList(one);
        while (one != null) {
            System.out.println(one.data);
            one = one.next;
        }
    }

    private static void removeDuplicateSortedList(SLLNode node) {
        SLLNode current = node;
        SLLNode prev = null;

        while (current != null) {
            if (prev != null && prev.data == current.data) {
                //remove duplicates
                prev.next = current.next;
            }
            prev = current;
            current = current.next;
        }
    }
}
