package com.thread;

public class OddEvenPrinterTest {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread even = new Thread(new OddEvenThread(printer, 100, true), "even");
        Thread odd = new Thread(new OddEvenThread(printer, 100, false), "odd");
        even.start();
        odd.start();
    }
}
