package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class evenOddSegregate {

    public static void main(String[] args) {
        SLLNode node1 = new SLLNode(1);
        SLLNode node2 = new SLLNode(2);
        SLLNode node3 = new SLLNode(3);
        SLLNode node4 = new SLLNode(4);
        SLLNode node5 = new SLLNode(5);
        SLLNode node6 = new SLLNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        SLLNode<Integer> result = evenOddMerge(node1);

        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }

    // brute force using two list
    private static SLLNode<Integer> evenOddMerge(SLLNode<Integer> L1) {

        if (L1 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        SLLNode<Integer> temp = L1;
        SLLNode<Integer> even = new SLLNode<>();
        SLLNode<Integer> odd = new SLLNode<>();

        SLLNode<Integer> evenTemp = even;
        SLLNode<Integer> oddTemp = odd;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                even.next = temp;
                even = even.next;
            } else {
                oddTemp.next = temp;
                oddTemp = temp;
            }
            temp = temp.next;
        }

        even = even.next;
        even.next.next = odd.next;

        return even;
    }
}
