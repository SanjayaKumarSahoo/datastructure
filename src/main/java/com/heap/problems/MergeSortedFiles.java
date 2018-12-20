package com.heap.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedFiles {

    public static void main(String[] args) {

        Stock stock1 = new Stock(1, "AAPL", 38, 456.12);
        Stock stock2 = new Stock(3, "AAPL", 38, 456.12);
        Stock stock3 = new Stock(5, "AAPL", 38, 456.12);
        Stock stock4 = new Stock(7, "AAPL", 38, 456.12);
        List<Stock> file1 = Arrays.asList(stock1, stock2, stock3, stock4);

        Stock stock5 = new Stock(2, "AAPL", 38, 456.12);
        Stock stock6 = new Stock(15, "AAPL", 38, 456.12);
        List<Stock> file2 = Arrays.asList(stock5, stock6);

        Stock stock7 = new Stock(0, "AAPL", 38, 456.12);
        Stock stock8 = new Stock(9, "AAPL", 38, 456.12);
        Stock stock9 = new Stock(10, "AAPL", 38, 456.12);
        Stock stock10 = new Stock(11, "AAPL", 38, 456.12);
        List<Stock> file3 = Arrays.asList(stock7, stock8, stock9, stock10);

        List<Stock> result = mergeSortedFiles(Arrays.asList(file1, file2, file3));

        for (Stock element : result) {
            System.out.println(element);
        }
    }

    private static List<Stock> mergeSortedFiles(List<List<Stock>> files) {

        if (files.isEmpty()) {
            return new ArrayList<>();
        }

        if (files.size() == 1) {
            return files.get(0);
        }

        // covert to array entry
        List<List<ArrayEntry>> listEntry = new ArrayList<>();
        int i = 0;
        for (List<Stock> file : files) {
            List<ArrayEntry> entries = new ArrayList<>();
            for (Stock stock : file) {
                ArrayEntry arrayEntry = new ArrayEntry(stock, i);
                entries.add(arrayEntry);
            }
            listEntry.add(entries);
            i++;
        }

        List<Iterator<ArrayEntry>> iterators = new LinkedList<>();

        // create iterators from list
        for (List<ArrayEntry> file : listEntry) {
            iterators.add(file.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Long.compare(o1.getStock().getTimestamp(), o2.getStock().getTimestamp());
            }
        });


        // adding first elements of each list
        for (Iterator<ArrayEntry> itr : iterators) {
            if (itr.hasNext()) {
                minHeap.add(itr.next());
            }
        }

        List<Stock> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            result.add(headEntry.getStock());
            int arrayId = headEntry.getArrayId();
            if (iterators.get(arrayId).hasNext()) {
                minHeap.add(iterators.get(arrayId).next());
            }
        }
        return result;
    }


    private static class ArrayEntry {
        private final Stock stock;
        private final int arrayId;

        public ArrayEntry(Stock stock, int arrayId) {
            this.stock = stock;
            this.arrayId = arrayId;
        }

        public Stock getStock() {
            return stock;
        }

        public int getArrayId() {
            return arrayId;
        }
    }

    private static class Stock {
        private final long timestamp;
        private final String stock;
        private final long qty;
        private final double price;

        public Stock(long timestamp, String stock, long qty, double price) {
            this.timestamp = timestamp;
            this.stock = stock;
            this.qty = qty;
            this.price = price;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public String getStock() {
            return stock;
        }

        public long getQty() {
            return qty;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Stock{" +
                    "timestamp=" + timestamp +
                    ", stock='" + stock + '\'' +
                    ", qty=" + qty +
                    ", price=" + price +
                    '}';
        }
    }
}