package com.bastronaut.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Created by BSijtsma on 03-04-2017.
 *
 * custom arraylist impl with resizing as practice
 * api:
 *  T get(int index)
 *  T remove(int index)
 *  boolean add(T t) // boolean as specified by Collection
 *  int indexOf(T t)
 *  hasValue(T t)
 *  int size()
 *
 */
public class CustomArrayList <T> implements Iterable {

    int n;
    T[] container = (T[]) new Object[2]; // default size for easy testing

    public T get(int i) {
        if (isOutOfBounds(i)) {
            throw new IndexOutOfBoundsException();
        } else {
            return container[i];
        }
    }

    // removes at index and moves all remaining elements in previous slot
    // TODO: resizing to smaller container when they array is half empty?
    // search if this is a good idea
    public T remove(int i) {
        if (isOutOfBounds(i)) {
            throw new IndexOutOfBoundsException();
        } else {
            T returnValue = container[i];
            for (int j = i; j < n-1; j++) {
                if (container[j] == null) {
                    break;
                }
                container[j] = container[j+1];
            }
            n--;
            return returnValue;
        }
    }

    public boolean add(T t) {
        if (isFull()) {
            this.container = resize(this.container, size() * 2);
        }
        this.container[n] = t;
        n++;
        return true;
    }

    public int size() {
        return n;
    }

    public int indexOf(T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size(); i++) {
            if (t == container[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean hasValue(T t) {
        if (t == null) {
            throw new IllegalArgumentException();
        }
        boolean hasValue = false;
        for (T val : container) {
            if (t == val) {
                hasValue = true;
                break;
            }
        }
        return hasValue;
    }

    private T[] resize(T[] container, int size) {
        T[] newContainer = (T[]) new Object[size];
        for (int i = 0; i < container.length; i++) {
            newContainer[i] = container[i];
        }
        return newContainer;
    }

    private boolean isOutOfBounds(int i) {
        return (i < 0 || i > n-1);
    }

    private boolean isFull() {
        return n == container.length;
    }


    @Override
    public Iterator iterator() {
        return new CustomArrayListIterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterator it = new CustomArrayListIterator();
        while (it.hasNext()) {
            action.accept(it.next());
        }
    }

    private class CustomArrayListIterator implements Iterator<T> {

        private int iteratorN = 0;

        @Override
        public boolean hasNext() {
            if (iteratorN < n) {
                iteratorN++;
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (iteratorN == 0) {
                throw new NoSuchElementException();
            }
            if (container[iteratorN-1] == null) {
                throw new NoSuchElementException();
            }
            return container[iteratorN-1];
        }

    }
}
