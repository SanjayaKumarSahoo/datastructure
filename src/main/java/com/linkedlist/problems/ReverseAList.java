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
        SLLNode<Integer> prev = null;
        SLLNode<Integer> next = null;
        SLLNode<Integer> temp = node;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        node = prev;
        return node;
    }
}
