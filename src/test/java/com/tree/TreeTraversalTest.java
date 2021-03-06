package com.tree;

import com.tree.problems.traversal.TreeTraversal;
import org.junit.Assert;
import org.junit.Test;

public class TreeTraversalTest {

    TreeTraversal traversal = new TreeTraversal();

    @Test
    public void testInOrder() {
        Node six = new Node();
        six.data = 6;

        Node three = new Node();
        three.data = 3;
        three.left = six;


        Node<Integer> four = new Node<>();
        four.data = 4;

        Node five = new Node();
        five.data = 5;

        Node two = new Node();
        two.data = 2;
        two.left = four;
        two.right = five;

        Node one = new Node();
        one.data = 1;
        one.left = two;
        one.right = three;

        String data = traversal.inOrder(one);

        Assert.assertEquals(data, "425163");
    }

    @Test
    public void testPreOrder() {
        Node six = new Node();
        six.data = 6;

        Node three = new Node();
        three.data = 3;
        three.left = six;

        Node<Integer> four = new Node<>();
        four.data = 4;

        Node five = new Node();
        five.data = 5;

        Node two = new Node();
        two.data = 2;
        two.left = four;
        two.right = five;

        Node one = new Node();
        one.data = 1;
        one.left = two;
        one.right = three;

        String data = traversal.preOrder(one);

        Assert.assertEquals(data, "124536");
    }

    @Test
    public void testLevelOrderTraversal() {
        Node six = new Node();
        six.data = 6;

        Node three = new Node();
        three.data = 3;
        three.left = six;


        Node<Integer> four = new Node<>();
        four.data = 4;

        Node five = new Node();
        five.data = 5;

        Node two = new Node();
        two.data = 2;
        two.left = four;
        two.right = five;

        Node one = new Node();
        one.data = 1;
        one.left = two;
        one.right = three;

        String data = traversal.levelOrderTraversal(one);
        Assert.assertEquals(data, "123456");
    }
}
