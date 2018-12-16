package com.tree.problems.summation;

import com.tree.Node;

public class SumBinaryTree {


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
        System.out.println(sum(one));
    }

    private static int sum(Node<Integer> root) {
        if (root == null) {
            return 0;
        }
        int result = root.data + sum(root.left) + sum(root.right);
        return result;
    }
}
