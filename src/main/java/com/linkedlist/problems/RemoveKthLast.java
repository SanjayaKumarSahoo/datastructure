package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class RemoveKthLast {

    public static void main(String[] args) {
        // 1->2->3->4->NULL
        SLLNode<Integer> one = new SLLNode<Integer>(1);
        SLLNode<Integer> two = new SLLNode<Integer>(2);
        SLLNode<Integer> three = new SLLNode<Integer>(3);
        SLLNode<Integer> four = new SLLNode<Integer>(4);
        SLLNode<Integer> five = new SLLNode<Integer>(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        SLLNode data = removeKthLast(one, 2);
        while (data != null) {
            System.out.println(data.data);
            data = data.next;
        }
    }

    private static SLLNode removeKthLasWithSizeCalculation(SLLNode node, int k) {
        if (node == null) {
            throw new IllegalArgumentException("Node is empty");
        }

        SLLNode temp = node;
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (k > size) {
            throw new IllegalArgumentException("K is greater than size of list");
        }

        temp = node;
        for (int i = 0; i < size - k - 1; i++) {
            temp = temp.next;
        }

        if (temp != null & temp.next != null) {
            temp.next = temp.next.next;
        }
        return node;
    }

    // without size calculation (with help of two pointer)
    private static SLLNode removeKthLast(SLLNode node, int k) {

        if (node == null) {
            throw new IllegalArgumentException("Node is empty");
        }

        SLLNode first = node;
        while (k + 1 > 0) {
            first = first.next;
            k = k - 1;
        }

        SLLNode second = node;
        while (first != null) {
            second = second.next;
            first = first.next;
        }

        if (second != null && second.next != null) {
            second.next = second.next.next;
        }
        return node;
    }
}
