package com.tree.bst;

import com.tree.Node;

public class SearchElementBST {

    public static void main(String[] args) {
        Node<Integer> root = prepareBST();
        Node<Integer> element = findElement(root, 23);
        if (element != null) {
            System.out.println(element.data);
        }
    }


    private static Node<Integer> findElement(Node<Integer> root, Integer value) {
        if (root == null || root.data.equals(value)) {
            return root;
        }
        return value < root.data
                ? findElement(root.left, value)
                : findElement(root.right, value);
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
        H.data = 17;

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
        O.right = D;
        return A;
    }

}
