package com.linkedlist.problems;

        import com.linkedlist.singlylinkedlist.SinglyLinkedList.SLLNode;

public class ListPivoting {


    public static void main(String[] args) {
        SLLNode<Integer> node1 = new SLLNode<>(3);
        SLLNode<Integer> node2 = new SLLNode<>(2);
        SLLNode<Integer> node3 = new SLLNode<>(2);
        SLLNode<Integer> node4 = new SLLNode<>(11);
        SLLNode<Integer> node5 = new SLLNode<>(7);
        SLLNode<Integer> node6 = new SLLNode<>(5);
        SLLNode<Integer> node7 = new SLLNode<>(11);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        SLLNode<Integer> result = listPivoting(node1, 7);

        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }

    }

    public static SLLNode<Integer> listPivoting(SLLNode<Integer> node, int k) {

        if (node == null || k == 0) {
            return node;
        }

        SLLNode<Integer> lesserHead = new SLLNode<>();
        SLLNode<Integer> equalHead = new SLLNode<>();
        SLLNode<Integer> greaterHead = new SLLNode<>();

        SLLNode<Integer> lesserIter = lesserHead;
        SLLNode<Integer> equalIter = equalHead;
        SLLNode<Integer> greaterIter = greaterHead;

        SLLNode<Integer> temp = node;

        while (temp != null) {

            if (temp.data < k) {
                lesserIter.next = temp;
                lesserIter = temp;
            }

            if (temp.data > k) {
                greaterIter.next = temp;
                greaterIter = temp;
            }

            if (temp.data == k) {
                equalIter.next = temp;
                equalIter = temp;
            }
            temp = temp.next;
        }
        lesserIter.next = equalHead.next;
        equalIter.next = greaterHead.next;

        return lesserHead.next;
    }
}
