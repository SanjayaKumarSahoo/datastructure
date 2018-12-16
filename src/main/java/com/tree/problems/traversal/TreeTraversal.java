package com.tree.problems.traversal;

import com.queue.LinkedListBasedQueue;
import com.stack.LinkListBasedStack;
import com.tree.Node;

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


    public String levelOrderTraversal(Node root) {
        Node temp = root;
        if (temp == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        LinkedListBasedQueue<Node> queue = new LinkedListBasedQueue<>();
        queue.enQueue(temp);

        while (!queue.isEmpty()) {
            Node node = queue.deQueue();
            builder.append(node.data);

            if (node.left != null) {
                queue.enQueue(node.left);
            }

            if (node.right != null) {
                queue.enQueue(node.right);
            }
        }
        return builder.toString();
    }
}
