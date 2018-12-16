package com.tree.problems.traversal;

import com.tree.Node;

public class TreeTraversalRecursion {
    public static void main(String[] args) {
        Node<Integer> one = new Node<>();
        one.data = 1;

        Node<Integer> two = new Node<>();
        two.data = 2;

        Node<Integer> three = new Node<>();
        three.data = 3;

        Node<Integer> four = new Node<>();
        four.data = 4;

        Node<Integer> five = new Node<>();
        five.data = 5;

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        preOrder(one);
    }


    private static void inOrder(Node<Integer> root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }

    private static void preOrder(Node<Integer> root) {

        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node<Integer> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }
}
