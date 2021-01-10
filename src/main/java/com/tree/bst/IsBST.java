package com.tree.bst;

import com.tree.Node;

public class IsBST {

    public static void main(String[] args) {
        Node<Integer> root = prepareBST();
        boolean isBST = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Is BST : " + isBST);
    }


    private static boolean isBST(Node<Integer> root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        } else if (Integer.compare(root.data, lower) < 0
                || Integer.compare(root.data, upper) > 0) {
            return
                    false;
        }
        return isBST(root.left, lower, root.data)
                && isBST(root.right, root.data, upper);
    }

    private static Node<Integer> prepareBST() {

        Node<Integer> A = new Node<>();
        A.data = 19;

        Node<Integer> B = new Node<>();
        B.data = 7;

        Node<Integer> C = new Node<>();
        C.data = 3;

        Node<Integer> D = new Node<>();
        D.data = 2;

        Node<Integer> E = new Node<>();
        E.data = 5;

        Node<Integer> F = new Node<>();
        F.data = 11;

        Node<Integer> G = new Node<>();
        G.data = 17;

        Node<Integer> H = new Node<>();
        H.data = 13;

        Node<Integer> I = new Node<>();
        I.data = 43;

        Node<Integer> J = new Node<>();
        J.data = 23;

        Node<Integer> K = new Node<>();
        K.data = 37;

        Node<Integer> L = new Node<>();
        L.data = 29;

        Node<Integer> M = new Node<>();
        M.data = 31;

        Node<Integer> N = new Node<>();
        N.data = 41;

        Node<Integer> O = new Node<>();
        O.data = 47;

        Node<Integer> P = new Node<>();
        P.data = 53;

        A.left = B;
        A.right = I;
        B.left = C;
        B.right = F;
        C.left = D;
        C.right = E;
        F.right = G;
        G.left = H;
        I.left = J;
        I.right = O;
        J.right = K;
        K.left = L;
        K.right = N;
        L.right = M;
        O.right = P;
        return A;
    }
}
