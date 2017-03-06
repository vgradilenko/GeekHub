package com.geekhub.collections;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> elementsList = new ArrayList<>();

        for (E current : elements) {
            if (filter.test(current)) {
                elementsList.add(current);
            }
        }
        return elementsList;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        if (elements.isEmpty()) {
            return false;
        }

        for (E current : elements) {
            if (predicate.test(current)) {
                return true;
            }
        }

        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        int count = 0;

        for (E element : elements) {
            count = Collections.frequency(elements, element);
        }

        return elements.size() == count;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        return !anyMatch(elements, predicate);
    }

    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> list = new ArrayList<>();

        for (T element : elements) {
            list.add(mappingFunction.apply(element));
        }

        return list;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        }

        E maxElement = null;
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0) {
                maxElement = elements.get(i);
            } else {
                int result = comparator.compare(maxElement, elements.get(i));

                if (result < 0) {
                    maxElement = elements.get(i);
                }
            }
        }

        return Optional.of(maxElement);
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        }

        E minElement = null;
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0) {
                minElement = elements.get(i);
            } else {
                int result = comparator.compare(minElement, elements.get(i));

                if (result > 0) {
                    minElement = elements.get(i);
                }
            }
        }

        return Optional.of(minElement);
    }

    public static <E> List<E> distinct(List<E> elements) {
        Set<E> set = new HashSet<>(elements);
        return new ArrayList<>(set);
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements) {
            consumer.accept(element);
        }
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(reduce(elements.get(0), elements, accumulator));
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.isEmpty()) {
            return null;
        }

        E accumulateElements = null;
        int count = elements.indexOf(seed);

        for (int i = count; i < elements.size(); i++) {
            if (i == count) {
                accumulateElements = elements.get(i);
            } else {
                accumulateElements = accumulator.apply(accumulateElements, elements.get(i));
            }
        }

        return accumulateElements;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        Map<Boolean, List<E>> map = new HashMap<>();
        List<E> resultTrue = new ArrayList<>();
        List<E> resultFalse = new ArrayList<>();

        for (E current : elements) {
            if (predicate.test(current)) {
                resultTrue.add(current);
            } else {
                resultFalse.add(current);
            }

            map.put(Boolean.TRUE, resultTrue);
            map.put(Boolean.FALSE, resultFalse);
        }
        return map;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        HashMap<K, List<T>> map = new HashMap<>();

        for (T current : elements) {
            if (map.get(classifier.apply(current)) == null) {
                map.put(classifier.apply(current), new ArrayList<>());
            }

            map.get(classifier.apply(current)).add(current);
        }

        return map;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        HashMap<K, U> map = new HashMap<>();

        for (int i = 0; i < elements.size(); i++) {

            K key = keyFunction.apply(elements.get(i));
            U value = valueFunction.apply(elements.get(i));

            if (map.containsKey(key)) {
                value = mergeFunction.apply(map.get(key), value);
                map.put(key, value);
            } else {
                map.put(key, value);
            }
        }

        return map;
    }

    public static void main(String[] args) {

    }
}
