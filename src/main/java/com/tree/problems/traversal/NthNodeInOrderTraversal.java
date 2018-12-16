package com.tree.problems.traversal;

import com.tree.Node;

public class NthNodeInOrderTraversal {

    static int count = 0;

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

        findNthNode(A, 3);

    }

    private static void findNthNode(Node<String> root, int n) {

        if (root == null)
            return;

        if (count <= n) {
            findNthNode(root.left, n);
            count++;
            if (count == n) {
                System.out.printf(root.data);
            }
            findNthNode(root.right, n);
        }
    }
}
