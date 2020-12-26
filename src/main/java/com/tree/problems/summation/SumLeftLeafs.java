package com.tree.problems.summation;

import com.tree.Node;

public class SumLeftLeafs {

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

        System.out.println(sumLeftLeafs(one));
    }

    private static int sumLeftLeafs(Node<Integer> node) {
        int result = 0;
        if (node != null) {
            if (isLeaf(node.left)) {
                result = result + ((Node<Integer>) node.left).data;
            } else {
                result = result + sumLeftLeafs(node.left);
            }
            result = result + sumLeftLeafs(node.right);
        }
        return result;
    }

    private static boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
