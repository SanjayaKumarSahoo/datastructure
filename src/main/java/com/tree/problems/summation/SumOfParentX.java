package com.tree.problems.summation;

import com.tree.Node;

public class SumOfParentX {
    static int sum = 0;

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

        one.left = three;
        one.right = two;

        three.left = four;
        three.right = two;
        sumOfParentX(one, 2);
        System.out.println(sum);
    }

    private static void sumOfParentX(Node<Integer> root, int x) {
        if (root == null) {
            return;
        }

        if ((root.left != null && (int) root.left.data == x) || (root.right != null && (int) root.right.data == x))
            sum += root.data;

        sumOfParentX(root.left, x);
        sumOfParentX(root.right, x);
    }
}
