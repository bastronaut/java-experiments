package com.bastronaut.linkedlist;

import com.sun.istack.internal.Nullable;

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
    @Nullable
    public V search(K key) {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node tempNode = topNode;
        V value = recursiveSearch(tempNode, key);
        return value;
    }

    private V recursiveSearch(Node node, K key) {
        if (node.key.equals(key)) {
            return node.value;
        } else {
            if (node.next != null) {
                return recursiveSearch(node.next, key);
            } else {
                return null;
            }
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
