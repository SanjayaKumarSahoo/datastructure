package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class LinkedListAPalindrome {


    public static void main(String[] args) {
        SLLNode<Integer> node1 = new SLLNode(1);
        SLLNode<Integer> node2 = new SLLNode(2);
        SLLNode<Integer> node3 = new SLLNode(2);
        SLLNode<Integer> node4 = new SLLNode(2);
        SLLNode<Integer> node5 = new SLLNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(isPalindrome(node1));
    }


    private static boolean isPalindrome(SLLNode<Integer> node) {

        if (node == null) {
            return true;
        }

        SLLNode<Integer> slow = node;
        SLLNode<Integer> fast = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        SLLNode<Integer> firstHalf = node;
        SLLNode<Integer> secondHalf = reverse(slow);


        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private static SLLNode<Integer> reverse(SLLNode<Integer> node) {
        SLLNode<Integer> previous = null;
        SLLNode<Integer> next;
        SLLNode<Integer> current = node;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        node = previous;
        return node;
    }
}
