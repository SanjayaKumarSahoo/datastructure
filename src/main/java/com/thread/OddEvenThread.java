package com.thread;

public class OddEvenThread implements Runnable {

    private final Printer printer;
    private final int max;
    private final boolean isEven;

    public OddEvenThread(Printer printer, int max, boolean isEven) {
        this.printer = printer;
        this.max = max;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        int number = isEven ? 2 : 1;
        while (number <= max) {
            if (isEven) {
                printer.printEven(number);
            } else {
                printer.printOdd(number);
            }
            number += 2;
        }
    }
}
