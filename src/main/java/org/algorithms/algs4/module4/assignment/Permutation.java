package org.algorithms.algs4.module4.assignment;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        RandomizedQueue q = new RandomizedQueue();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        for (int i = 0; i < size && !q.isEmpty(); i++)
            System.out.println(q.dequeue());
    }
}
