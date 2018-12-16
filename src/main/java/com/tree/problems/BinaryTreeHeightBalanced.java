package com.tree.problems;

import com.tree.Node;

// the difference in heights of the left and right children is greater than one
public class BinaryTreeHeightBalanced {


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

        Node<String> F = new Node<>();
        F.data = "F";

        Node<String> G = new Node<>();
        G.data = "G";

        Node<String> H = new Node<>();
        H.data = "H";

        Node<String> I = new Node<>();
        I.data = "I";

        Node<String> J = new Node<>();
        J.data = "J";

        Node<String> K = new Node<>();
        K.data = "K";

        Node<String> L = new Node<>();
        L.data = "L";

        Node<String> M = new Node<>();
        M.data = "M";

        Node<String> N = new Node<>();
        N.data = "N";

        Node<String> O = new Node<>();
        O.data = "O";

        A.left = B;
        A.right = K;
        K.left = L;
        K.right = O;
        L.left = M;
        L.right = N;

        B.left = C;
        B.right = H;
        H.left = I;
        H.right = J;

        C.left = D;
        C.right = G;

        D.left = E;
        D.right = F;

        System.out.println(isBalanced(A));
    }

    public static boolean isBalanced(Node<String> tree) {
        return checkBalanced(tree).balanced;
    }


    private static BalanceStatusWithHeight checkBalanced(Node<String> root) {
        if (root == null) {
            return new BalanceStatusWithHeight(true, -1);
        }

        BalanceStatusWithHeight leftResult = checkBalanced(root.left);

        if (!leftResult.balanced) {
            return leftResult; //left subtree is not balanced
        }

        BalanceStatusWithHeight rightResult = checkBalanced(root.right);
        if (!rightResult.balanced) {
            return rightResult; //right subtree is not balanced
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new BalanceStatusWithHeight(isBalanced, height);
    }

    private static class BalanceStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

}
