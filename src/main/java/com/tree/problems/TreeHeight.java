package com.tree.problems;

import com.tree.Node;

public class TreeHeight {

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

        System.out.println(height(one));
    }

    private static int height(Node<Integer> root) {
        if (root == null)
            return 0;
        else {
            /* compute the depth of each subtree */
            int lDepth = height(root.left);
            int rDepth = height(root.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
}
