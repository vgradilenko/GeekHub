package com.geekhub.task2.part1;

public class InsertionSort implements ArraySorter {
    @Override
    public Comparable[] sort(Comparable[] elements, Direction direction) {

        for (int i = 1; i < elements.length; i++) {
            Comparable index = elements[i];

            int j = i;

            if (direction == Direction.ASC) {
                while (j > 0 && (elements[j - 1].compareTo(index) == 1)) {
                    elements[j] = elements[j - 1];
                    j--;
                }
                elements[j] = index;
            } else if (direction == Direction.DESC) {
                while (j > 0 && (elements[j - 1].compareTo(index) == -1)) {
                    elements[j] = elements[j - 1];
                    j--;
                }
                elements[j] = index;
            }
        }

        return elements;
    }
}
