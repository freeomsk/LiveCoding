package ru.freeomsk;

import java.util.*;

public class EvenIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        EvenIterator evenIterator = new EvenIterator(numbers);
//        while (evenIterator.hasNext()) {
//            System.out.println(evenIterator.next());
//        }
        evenIterator.forEachRemaining(System.out::println);
    }

    private final Iterator<Integer> iterator;
    private Integer nextEven;

    public EvenIterator(Collection<Integer> collection) {
        this.iterator = collection.iterator();
        findNextEven();
    }

    private void findNextEven() {
        nextEven = null;
        while (iterator.hasNext()) {
            Integer current = iterator.next();
            if (current % 2 == 0) {
                nextEven = current;
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
        if (nextEven == null) {
            throw new NoSuchElementException();
        }
        Integer currentEven = nextEven;
        findNextEven();
        return currentEven;
    }
}