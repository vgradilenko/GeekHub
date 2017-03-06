package com.geekhub.task2.part1;

public class BubbleSort implements ArraySorter {
    @Override
    public Comparable[] sort(Comparable[] elements, Direction direction) {
        int sortResult;
        Comparable currentElement;

        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                sortResult = elements[i].compareTo(elements[j]);

                if (direction == Direction.ASC) {

                    if (sortResult == 1) {
                        currentElement = elements[i];
                        elements[i] = elements[j];
                        elements[j] = currentElement;
                    }
                } else if (direction == Direction.DESC) {

                    if (sortResult == -1) {
                        currentElement = elements[i];
                        elements[i] = elements[j];
                        elements[j] = currentElement;
                    }
                }
            }
        }

        return elements;
    }
}
