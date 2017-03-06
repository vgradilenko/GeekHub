package com.geekhub.task2.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSort {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car("zapor", 13));
        carList.add(new Car("bmw", 14));
        carList.add(new Car("hz", 1));
        carList.add(new Car("zapor", 1000));
        carList.add(new Car("zapor", 9));
        carList.add(new Car("zapor", 9999));
        carList.add(new Car("zapor", 0));
        carList.add(new Car("moscal", 11));

        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                int sortResult;

                if (String.valueOf(o1.getName().indexOf(2)).equals(String.valueOf(o2.getName().indexOf(2)))) {
                    sortResult = Integer.valueOf(o1.getPrice()).compareTo(o2.getPrice());
                }

                sortResult = o1.getName().compareTo(o2.getName());

                if (sortResult == 0) {
                    sortResult = Integer.valueOf(o1.getPrice()).compareTo(o2.getPrice());
                }

                return sortResult;
            }
        });

        for (Car car : carList) {
            System.out.println(car);
        }
    }
}
