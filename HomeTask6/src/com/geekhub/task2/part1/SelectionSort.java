package com.geekhub.task2.part1;

public class SelectionSort implements ArraySorter {
    @Override
    public Comparable[] sort(Comparable[] elements, Direction direction) {
        Comparable currentElement;

        for (int i = 0; i < elements.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < elements.length; j++)
                if (direction == Direction.ASC) {

                    if ((elements[j].compareTo(elements[min])) < 1)
                        min = j;
                    currentElement = elements[i];
                    elements[i] = elements[min];
                    elements[min] = currentElement;

                } else if (direction == Direction.DESC) {
                    if ((elements[min].compareTo(elements[j])) < 1)
                        min = j;
                    currentElement = elements[i];
                    elements[i] = elements[min];
                    elements[min] = currentElement;
                }
        }
        return elements;
    }
}
