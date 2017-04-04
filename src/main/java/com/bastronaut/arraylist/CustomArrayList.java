package com.bastronaut.arraylist;

/**
 * Created by BSijtsma on 03-04-2017.
 *
 * custom arraylist impl with resizing
 * api:
 *  T get(int index)
 *  T remove(int index)
 *  boolean add(T t) // boolean as specified by Collection
 *  int indexOf(T t)
 *  hasValue(T t)
 *  int size()
 *
 */
public class CustomArrayList <T> {

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
            container = resize(size() * 2);
        }

        return false;
    }

    public int size() {
        return n;
    }

    public int indexOf(T t) {
        return 0; // TODO
    }

    public boolean hasValue(T t) {
        return false; // TODO
    }

    private T[] resize(int size) {
        T[] newContainer = (T[]) new Object[size];
        for (int i = 0; i < container.length; i++) {
            newContainer[i] = container[i];
        }
        return newContainer;
    }

    private boolean isOutOfBounds(int i) {
        return (i < 0 || i < n-1);
    }

    private boolean isFull() {
        return n == container.length;
    }


}
