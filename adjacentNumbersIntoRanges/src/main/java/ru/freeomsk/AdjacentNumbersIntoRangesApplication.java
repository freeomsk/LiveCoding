package ru.freeomsk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class AdjacentNumbersIntoRangesApplication {
    public static void main(String[] args) {
        System.out.println(getCollapsedString(List.of(1, 4, 5, 2, 3, 9, 8, 11, 0)));
        System.out.println(getCollapsedString(List.of(1, 4, 3, 2)));
        System.out.println(getCollapsedString(List.of(1, 4)));
    }

    static class Range {
        public Range() {
        }

        public Integer start;
        public Integer end;
    }

    public static String getCollapsedString(List<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        List<Range> ranges = new ArrayList<>();
        Range currentRange = null;
        Integer previous = null;
        for (int i = 0; i < list.size(); i++) {
            Integer currentNum = list.get(i);
            if (currentRange == null) {
                currentRange = new Range();
            }
            if (currentRange.start == null) {
                currentRange.start = previous == null ? currentNum : previous;
                previous = currentNum;
            }
            if (previous != null && currentNum > previous + 1) {
                currentRange.end = previous;
                ranges.add(currentRange);
                currentRange = null;
            }
            if (i == list.size() - 1) {
                if (currentRange != null && currentRange.end == null) {
                    currentRange.end = currentNum;
                    ranges.add(currentRange);
                } else if (currentRange == null && !ranges.get(ranges.size() - 1).end.equals(currentNum)) {
                    currentRange = new Range();
                    currentRange.start = currentNum;
                    currentRange.end = currentNum;
                    ranges.add(currentRange);
                }
            }
            previous = currentNum;
        }
        return ranges.stream()
                .map(
                        range ->
                                !range.start.equals(range.end)
                                        ? range.start + "-" + range.end
                                        : String.valueOf(range.start))
                .collect(joining(","));
    }
}
