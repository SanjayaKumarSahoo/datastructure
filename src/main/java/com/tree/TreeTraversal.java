package com.tree;

import com.stack.LinkListBasedStack;

public class TreeTraversal {


    // Left, Root, Right
    public String inOrder(Node root) {
        StringBuilder result = new StringBuilder();
        Node temp = root;
        LinkListBasedStack<Node> stack = new LinkListBasedStack<>();

        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        while (stack.size() != 0) {
            Node node = stack.pop();
            result.append(node.data);
            if (node.right != null) {
                node = node.right;
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result.toString();
    }

    // Root, Left, Right
    public String preOrder(Node root) {
        Node temp = root;
        if (temp == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        LinkListBasedStack<Node> stack = new LinkListBasedStack<>();
        stack.push(temp);

        while (stack.size() != 0) {
            Node node = stack.pop();
            result.append(node.data);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result.toString();
    }


    //  Left, Right, Root
    public void postOrder(Node root) {
    }
}
