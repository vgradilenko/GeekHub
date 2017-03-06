package serializer.test;


import serializer.json.Ignore;
import serializer.json.adapter.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple Cat that will be used for testing JSON serialization.
 */
public class Cat {

    private int age;
    private String name;

    @Ignore
    private Cat myself;
    @UseDataAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;

    @UseDataAdapter(ColorAdapter.class)
    private Color color;

    @UseDataAdapter(CollectionAdapter.class)
    private List<Integer> whiskers = new ArrayList<>();

    @UseDataAdapter(MapAdapter.class)
    private Map<String, Paw> paws = new HashMap<>();

    public Cat() {
        myself = this;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Map<String, Paw> getPaws() {
        return paws;
    }

    public void setPaws(Map<String, Paw> paws) {
        this.paws = paws;
    }

    public List<Integer> getWhiskers() {
        return whiskers;
    }

    public void setWhiskers(List<Integer> whiskers) {
        this.whiskers = whiskers;
    }

    public Cat getMyself() {
        return myself;
    }

    public void setMyself(Cat myself) {
        this.myself = myself;
    }
}