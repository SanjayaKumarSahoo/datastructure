package com.tree.problems.traversal;

import com.tree.Node;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {

        Node<String> A = new Node<>();
        A.data = "A";

        Node<String> B = new Node<>();
        B.data = "B";

        Node<String> C = new Node<>();
        C.data = "C";

        Node<String> D = new Node<>();
        D.data = "D";

        Node<String> E = new Node<>();
        E.data = "E";

        A.left = B;
        A.right = E;

        B.left = C;
        B.right = D;

        printReverseLevelOrder(A);
    }


    public static void printReverseLevelOrder(Node<String> root) {
        if (root == null) {
            return;
        }

        Stack<Node<String>> stack = new Stack<>();
        LinkedList<Node<String>> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node<String> node = queue.getFirst();
            stack.push(node);

            queue.removeFirst();

            if (node.right != null) {
                queue.addLast(node.right);
            }

            if (node.left != null) {
                queue.addLast(node.left);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }
    }
}
