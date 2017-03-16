package com.bastronaut.linkedlist;

import com.sun.istack.internal.Nullable;

import java.util.EmptyStackException;

/**
 * Created by BSijtsma on 07-02-2017.
 * A custom linked list implementation to be used in the HashMap experiment.
 * Stack with push(), pop(), remove(), search()
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
        if (!isEmpty()) {
            sb.append(node.toString());
        }
        while (node.next != null) {
            sb.append(node.next.toString());
            node = node.next;
        }
        return sb.toString();
    }

    /**
     * Removing from linkedlist: set reference from prev node to next node, and value to null for gc
     *  todo: untested, write testcases
     * @param key
     * @return
     */
    public V remove(K key) {
        if (isEmpty()) {
            return null;
        }
        V value = null;

        if (bottomNode.key == key) {
            value = bottomNode.value;

            if (bottomNode.next != null) {
                bottomNode.value = null;
                bottomNode = bottomNode.next;
            }
        } else {
            Node currentNode = bottomNode;
            Node prevNode = bottomNode;
            if (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            while (currentNode != null) {
                if (currentNode.key == key) {
                    value = currentNode.value;
                    currentNode.value = null;
                    prevNode.next = currentNode.next;
                    return value;
                } else {
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
        }
        return value;
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
            return this.key.toString() + ": " + this.value + "; ";
        }
    }

}
