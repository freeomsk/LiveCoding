package ru.freeomsk;

import java.util.*;

public class MyIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Iterator<Integer> iter = new MyIterator(list);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private final Iterator<Integer> iterator;
    private Integer nextEven;

    public MyIterator(Collection<Integer> collection) {
        this.iterator = collection.iterator();
        findNextEven();
    }

    private void findNextEven() {
        nextEven = null;
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val % 2 == 0) {
                nextEven = val;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextEven != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = nextEven;
        findNextEven();
        return result;
    }
}