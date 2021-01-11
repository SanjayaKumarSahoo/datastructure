package com.queue.problems;

import java.util.LinkedList;

public class MaxAPIQueue {

    private LinkedList<Element> list = new LinkedList<>();

    public int deQueue() {
        return list.removeFirst().data;
    }

    public void enQueue(int data) {
        Element element = new Element(data, max() > data ? max() : data);
        list.addLast(element);
    }

    public int max() {
        if (list.size() == 0) {
            return Integer.MIN_VALUE;
        } else {
            return list.getLast().max;
        }
    }

    public class Element {

        int data;
        int max;

        public Element(int data, int max) {
            this.data = data;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        MaxAPIQueue queue = new MaxAPIQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(-5);

        System.out.println(queue.max());


    }

}
