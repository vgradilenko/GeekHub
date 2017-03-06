package com.geekhub.collections;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestUtils {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("for");
        strings.add("test");
        strings.add("hw");
        strings.add("hw");
        strings.add("this_very_very_looong_word");
        strings.add("part");
        strings.add("part");
        strings.add("part");

        System.out.println(CollectionUtils.filter(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() <= 2;
            }
        }));

        System.out.println(CollectionUtils.anyMatch(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("p");
            }
        }));

        System.out.println(CollectionUtils.allMatch(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("2");
            }
        }));

        System.out.println(CollectionUtils.noneMatch(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("2");
            }
        }));

        System.out.println(CollectionUtils.map(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }));

        System.out.println(CollectionUtils.max(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }));

        System.out.println(CollectionUtils.min(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }));

        System.out.println(CollectionUtils.distinct(strings));

        CollectionUtils.forEach(strings, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println(CollectionUtils.reduce(strings, new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s + "_" + s2;
            }
        }));

        System.out.println(CollectionUtils.partitionBy(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        }));

        System.out.println(CollectionUtils.groupBy(strings, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }));

        System.out.println(CollectionUtils.toMap(strings,
                new Function<String, String>() {
                    @Override
                    public String apply(String key) {
                        return key.substring(0, 1).toUpperCase();
                    }
                }, new Function<String, String>() {
                    @Override
                    public String apply(String value) {
                        return value.substring(1, value.length());
                    }
                }, new BinaryOperator<String>() {
                    @Override
                    public String apply(String s, String s2) {
                        return s + "_::_" + s;
                    }
                }));
    }
}
