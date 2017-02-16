package com.bastronaut.linkedlist;

import com.sun.istack.internal.Nullable;

import java.util.EmptyStackException;

/**
 * Created by BSijtsma on 07-02-2017.
 * A custom linked list implementation to be used in the HashMap experiment.
 * This implements a stack with push() and pop(), and a  V search(K key)
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

            Node existingNode = searchNodeByKey(key);
            if (existingNode == null) {
                Node newTopNode = new Node(key, item);
                newTopNode.next = topNode;
                topNode = newTopNode;
            } else {
                existingNode.value = item;
            }
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
        Node node = searchNodeByKey(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Nullable
    private Node searchNodeByKey(K key) {
        if (isEmpty()) {
            return null;
        }
        Node tempNode = topNode;
        Node node = recursiveSearch(tempNode, key);
        return node;
    }

    private Node recursiveSearch(Node node, K key) {
        if (node.key.equals(key)) {
            return node;
        } else {
            if (node.next != null) {
                return recursiveSearch(node.next, key);
            } else {
                return null;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = topNode;
        while (node.next != null) {
            sb.append(node.toString());
            node = node.next;
        }
        return sb.toString();
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


        public String toString() {
            return this.key.toString() + ": " + this.value + "\n";
        }
    }

}
