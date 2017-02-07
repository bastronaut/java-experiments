package com.bastronaut.linkedlist;

import java.util.EmptyStackException;

/**
 * Created by BSijtsma on 07-02-2017.
 * A custom linked list implementation to be used for ex in the HashMap experiment.
 * This implements a stack with push() and pop() for now
 */
public class LinkedList <T> {

    private int N;
    private Node bottomNode;
    private Node topNode;

    public void push(T item) {
        if (isEmpty()) {
            bottomNode = new Node(item);
            topNode = bottomNode;
        } else {
            Node newTopNode = new Node(item);
            newTopNode.next = topNode;
            topNode = newTopNode;
        }
        N++;
    }
    public T pop() {
        T returnItem;
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            returnItem = topNode.item;
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

    public int getSize() {
        return N;
    }

    public boolean isEmpty() {
        return N < 1;
    }

    private class Node {
        public Node(T item) { this.item = item; }
        public T item;
        public Node next;
    }
}
