package com.tree.problems;

import com.tree.Node;

public class TreeSymmetry {

    public static void main(String[] args) {
        Node<Integer> A = new Node<>();
        A.data = 314;

        Node<Integer> B = new Node<>();
        B.data = 6;

        Node<Integer> C = new Node<>();
        C.data = 2;

        Node<Integer> D = new Node<>();
        D.data = 3;

        Node<Integer> E = new Node<>();
        E.data = 6;

        Node<Integer> F = new Node<>();
        F.data = 2;

        Node<Integer> G = new Node<>();
        E.data = 3;

        A.left = B;
        A.right = E;

        B.right = C;
        C.right = D;

        E.left = F;
        F.left = G;

        System.out.println(isSymmetric(A));

    }

    public static boolean isSymmetric(Node<Integer> root) {
        return root == null || checkSymmetric(root.left, root.right);
    }


    private static boolean checkSymmetric(Node<Integer> subtree0, Node<Integer> subtree1) {
        if (subtree0 == null && subtree1 == null) {
            return true;
        } else if (subtree0 != null && subtree1 != null) {
            return subtree0.data == subtree1.data
                    && checkSymmetric(subtree0.left, subtree1.right)
                    && checkSymmetric(subtree0.right, subtree1.left);
        }
        return false;
    }
}
