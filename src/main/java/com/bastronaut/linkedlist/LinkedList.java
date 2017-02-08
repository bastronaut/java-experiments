package com.bastronaut.linkedlist;

import java.util.EmptyStackException;

/**
 * Created by BSijtsma on 07-02-2017.
 * A custom linked list implementation to be used for ex in the HashMap experiment.
 * This implements a stack with push() and pop() for now
 */
public class LinkedList <K, V> {

    private int N;
    private Node bottomNode;
    private Node topNode;

    public void push(K key, V item) {
        if (isEmpty()) {
            bottomNode = new Node(key, item);
            topNode = bottomNode;
        } else {
            Node newTopNode = new Node(key, item);
            newTopNode.next = topNode;
            topNode = newTopNode;
        }
        N++;
    }
    public V pop() {
        V returnItem;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            returnItem = topNode.value;
            N--;
            if (isEmpty()) {
                topNode = null;
                bottomNode = null;
            } else {
                topNode = topNode.next;
            }
        }
        return returnItem;
    }

    // dedicated search method that traverses the LL in search for the key
    public V get(K key) {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node tempNode = bottomNode;
        if (bottomNode.key.equals(key)) {
            return bottomNode.value;
        } else {
            tempNode = bottomNode.next; // TODO
        }

    }

    public int getSize() {
        return N;
    }

    public boolean isEmpty() {
        return N < 1;
    }

    private class Node {
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K key;
        public V value;
        public Node next;

    }
}
