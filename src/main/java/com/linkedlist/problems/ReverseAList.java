package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class ReverseAList {

    public static void main(String[] args) {
        // 1->2->3->4->NULL
        SLLNode<Integer> one = new SLLNode<Integer>(1);
        SLLNode<Integer> two = new SLLNode<Integer>(2);
        SLLNode<Integer> three = new SLLNode<Integer>(3);
        SLLNode<Integer> four = new SLLNode<Integer>(4);
        one.next = two;
        two.next = three;
        three.next = four;

        SLLNode<Integer> reverse = reverse(one);
        while (reverse != null) {
            System.out.println(reverse.data);
            reverse = reverse.next;
        }
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
