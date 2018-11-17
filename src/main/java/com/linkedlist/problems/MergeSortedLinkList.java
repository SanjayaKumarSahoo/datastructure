package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class MergeSortedLinkList {

    public static void main(String[] args) {
        SLLNode node1 = new SLLNode(1);
        SLLNode node2 = new SLLNode(6);
        SLLNode node3 = new SLLNode(9);
        SLLNode node15 = new SLLNode(15);

        node1.next = node2;
        node2.next = node3;
        node3.next = node15;

        SLLNode node4 = new SLLNode(2);
        SLLNode node5 = new SLLNode(7);
        SLLNode node6 = new SLLNode(9);
        SLLNode node7 = new SLLNode(10);

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        SLLNode node = mergeSortedLinkList(node1, node4);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    private static SLLNode<Integer> mergeSortedLinkList(SLLNode<Integer> L1, SLLNode<Integer> L2) {
        SLLNode<Integer> temp1 = L1;
        SLLNode<Integer> temp2 = L2;

        SLLNode<Integer> temp = null;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                temp = temp1;
                temp1 = temp1.next;
                temp.next = temp2;
            } else {
                temp = temp2;
                temp2 = temp2.next;
                temp.next = temp1;
            }
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return L1;
    }
}
