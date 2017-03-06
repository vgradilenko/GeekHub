package com.geekhub.list;

public interface LinkedList<E> extends Iterable<E> {

    void add(E element);

    E get(int index);

    boolean contains(E element);

    boolean delete(E element);

    E delete(int index);

    boolean isEmpty();

    int size();

    int clean();

}
