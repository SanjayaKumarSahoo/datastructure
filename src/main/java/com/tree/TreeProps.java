package com.tree;

import com.queue.LinkedListBasedQueue;

public class TreeProps {

    public int findHeight(Node root) {
        Node temp = root;

        int height = 0;
        if (temp == null) {
            return height;
        }
        LinkedListBasedQueue<Node> queue = new LinkedListBasedQueue<>();
        queue.enQueue(temp);
        while (!queue.isEmpty()) {
            int size = queue.getSize();
            while (size-- >= 0) {
                Node node = queue.deQueue();
                if (node.left != null) {
                    queue.enQueue(node.left);
                }
                if (node.right != null) {
                    queue.enQueue(node.right);
                }
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        System.out.println(1%3);
    }
}
