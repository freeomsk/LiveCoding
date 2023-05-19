package ru.freeomsk;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {

    public static void main(String[] args) {
        int limit = 13;
        List<Integer> fibonacciSequence = generateFibonacciSequence(limit);

        System.out.println(fibonacciSequence);
    }
    public static List<Integer> generateFibonacciSequence(int n) {
        List<Integer> sequence = new ArrayList<>();

        if (n >= 1) {
            sequence.add(0);
        }

        if (n >= 2) {
            sequence.add(1);
        }

        int prev = 0;
        int current = 1;

        while (current <= n) {
            int next = prev + current;

            if (next <= n) {
                sequence.add(next);
            }

            prev = current;
            current = next;
        }

        return sequence;
    }
}