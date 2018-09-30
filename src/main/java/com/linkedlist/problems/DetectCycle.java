package com.linkedlist.problems;

import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

import java.util.HashMap;
import java.util.Map;

public class DetectCycle {

    public static void main(String[] args) {
        // 1->2->3->4->NULL
        SLLNode<Integer> one = new SLLNode<Integer>(1);
        SLLNode<Integer> two = new SLLNode<Integer>(2);
        SLLNode<Integer> three = new SLLNode<Integer>(3);
        SLLNode<Integer> four = new SLLNode<Integer>(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        System.out.println(detectCycleWithTwoPointer(one));
    }

    // using extra space
    private static boolean detectCycle(SLLNode<Integer> node) {

        if (node == null) {
            throw new IllegalArgumentException("Node is empty");
        }

        SLLNode temp = node;
        Map<SLLNode, Integer> visited = new HashMap<>();
        while (temp != null) {
            if (visited.get(temp) == null) {
                visited.put(temp, 1);
                temp = temp.next;
            } else {
                return true;
            }
        }
        return false;
    }

    // floyd detect cycle (with constant space)
    private static boolean detectCycleWithTwoPointer(SLLNode<Integer> node) {
        if (node == null) {
            throw new IllegalArgumentException("Node is empty");
        }

        SLLNode first = node;
        SLLNode slow = node;
        SLLNode temp = node;

        while (temp != null) {

            if (slow == first && temp != node) {
                return true;
            }

            // move slow one step
            if (slow != null) {
                slow = slow.next;
            }

            // move first two step
            if (first != null) {
                first = first.next;
                if (first != null) {
                    first = first.next;
                }
            }
            temp = temp.next;
        }
        return false;
    }
}
