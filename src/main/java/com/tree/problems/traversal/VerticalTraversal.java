package com.tree.problems.traversal;

import com.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {

    public static void main(String[] args) {

    }

    private static void verticalTraversalRecursion() {

    }

    // by using level order traversal
    private static void verticalTraversalIterative(Node<Integer> root) {
        if (root == null) {
            throw new RuntimeException("Tree root is null");
        }
        Map<Integer, List<Integer>> values = new TreeMap<>();
        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(root, 0));
        while (!queue.isEmpty()) {
            Element element = queue.poll();
            Node<Integer> node = element.node;
            int distance = element.distance;
            storeIntoMap(values, distance, node.data);
            if (node.left != null) {
                queue.offer(new Element(node.left, distance - 1));
            }
            if (node.right != null) {
                queue.offer(new Element(node.right, distance + 1));
            }
        }
        // print the TreeMap
        for (List<Integer> list : values.values()) {
            System.out.println(list);
        }
    }

    private static void storeIntoMap(Map<Integer, List<Integer>> values, int distance, int data) {
        if (values.containsKey(distance)) {
            List<Integer> datas = values.get(distance);
            datas.add(data);
        } else {
            ArrayList<Integer> list = new ArrayList();
            list.add(data);
            values.put(distance, list);
        }
    }

    public static final class Element {
        public Node<Integer> node;
        public int distance;

        public Element(Node<Integer> node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }
    }
}