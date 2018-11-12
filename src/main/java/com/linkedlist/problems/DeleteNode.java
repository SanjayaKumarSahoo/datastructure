package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class DeleteNode {

    public static void main(String[] args) {
        SLLNode node1 = new SLLNode(1);
        SLLNode node2 = new SLLNode(2);
        SLLNode node3 = new SLLNode(3);
        SLLNode node4 = new SLLNode(4);
        SLLNode node5 = new SLLNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        SLLNode node = deleteNode(node1, 5);

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static SLLNode deleteNode(SLLNode<Integer> L, Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        SLLNode<Integer> temp = L;
        SLLNode<Integer> prev = null;

        while (temp != null) {
            if (temp.data == value) {
                if (prev == null) {
                    L = temp.next;
                } else {
                    prev.next = temp.next;
                }
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return L;
    }
}
