package com.tree.problems.traversal;

import com.queue.LinkedListBasedQueue;
import com.tree.Node;

public class LevelOrderTraversal {

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

        A.left = B;
        A.right = E;

        B.left = C;
        B.right = D;

        levelOrderTraversalWithQueue(A);
    }

    private static void levelOrderTraversal(Node<String> root) {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevelOrder(root, i);
        }
    }

    private static void printLevelOrder(Node<String> root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.println(root.data);
        } else if (level > 1) {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    private static int height(Node<String> root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }


    private static void levelOrderTraversalWithQueue(Node<String> root) {

        LinkedListBasedQueue<Node<String>> q = new LinkedListBasedQueue();
        q.enQueue(root);

        while (!q.isEmpty()) {
            Node<String> d = q.deQueue();
            System.out.println(d.data);
            if (d.left != null) {
                q.enQueue(d.left);
            }
            if (d.right != null) {
                q.enQueue(d.right);
            }
        }
    }
}
