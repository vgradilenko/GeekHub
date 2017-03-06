package com.geekhub.list;

import java.util.Iterator;

public class LinkedListImpl<E> implements LinkedList<E> {
    private int size = 0;

    private Node<E> tail;
    private Node<E> head;

    @Override
    public void add(E element) {

        if (head == null) {
            head = new Node<>(element, head);
        } else {
            Node<E> tmp = head;

            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = new Node<>(element, null);
        }

        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + " Size : " + size);
        }

        Node<E> element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }

        if (element == null) {
            throw new IndexOutOfBoundsException();
        }

        return element.value;
    }

    @Override
    public boolean contains(E element) {
        for (E current : this) {
            if (current.equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(E element) {
        if (this.contains(element)) {
            if (head.value.equals(element)) {
                head = head.next;
                return true;
            }

            Node<E> current = head;
            Node<E> prev = null;

            while (current != null && !current.value.equals(element)) {
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
            return true;
        }

        return false;
    }

    @Override
    public E delete(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size" + size);
        }

        E element = this.get(index);
        E copy = element;

        if (this.delete(element)) {
            return copy;
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int clean() {
        if (this.isEmpty()) {
            return 0;
        }

        for (int i = size - 1; i >= 0; i--) {
            this.delete(this.get(i));
        }

        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl<>(head);
    }

    private static class IteratorImpl<E> implements Iterator<E> {

        private Node<E> node;

        public IteratorImpl(Node<E> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E value = node.value;
            node = node.next;
            return value;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedListImpl<>();
        names.forEach(System.out::println);
        System.out.println(names.isEmpty());
        System.out.println(names.size());
        System.out.println("*****");
        names.add("John");
        names.forEach(System.out::println);
        System.out.println(names.isEmpty());
        System.out.println(names.size());
        System.out.println("*****");
        names.add("Joe");
        names.add("Jane");
        names.forEach(System.out::println);
        System.out.println(names.isEmpty());
        System.out.println(names.size());
        System.out.println("*****");
        names.delete(0);
        names.forEach(System.out::println);
        System.out.println("*****");
        names.add("Johny");
        names.forEach(System.out::println);
        System.out.println(names.isEmpty());
        System.out.println(names.size());
        System.out.println("*****");
        names.delete("Jane");
        names.forEach(System.out::println);
        System.out.println(names.isEmpty());
        System.out.println(names.size());
        System.out.println("*****");
        names.clean();
        names.forEach(System.out::println);
        System.out.println(names.isEmpty());
        System.out.println(names.size());
    }
}
