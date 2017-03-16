package com.bastronaut.hashmap;


import com.bastronaut.linkedlist.LinkedList;
import com.sun.istack.internal.Nullable;


/**
 * Created by BSijtsma on 01-02-2017.
 *
 * Experiment with recreating a HashMap data structure:
 * - a Key / value data structure
 * - Has fast (O(1) lookup through the use of 'bins' in which it stores values
 * (O(1) is assuming proper initialization with size and load factor)
 * - The bin is based on the hashCode of the key
 * - Start with simple implementation of a HashMap
 *
 * TODO:
 * resize array used in hashmap when load factor is reached
 *
 */
public class HashMapExperiment <K, V> {

    private int n;

    private LinkedList<K, V>[] itemContainer = new LinkedList[16]; // default size for hashmap in Oracle Java


    public void put(K key, V value) {
        int hashCode = getHashcode(key);

        int keyBin = hashCode % itemContainer.length;
        if (itemContainer[keyBin] == null) {
            LinkedList<K, V> ll = new LinkedList<>();
            ll.push(key, value);
            itemContainer[keyBin] = ll;
            n++;
        } else {
            if (itemContainer[keyBin].search(key) == null) {
                n++;
            }
            itemContainer[keyBin].push(key, value);
        }
    }

    @Nullable
    public V get(K key) {
        int hashCode = getHashcode(key);
        int hashIndex = hashCode % itemContainer.length;
        LinkedList<K, V> ll = itemContainer[hashIndex];
        if (itemContainer[hashIndex] != null) {
            return ll.search(key);
        } else {
            return null;
        }
    }

    public boolean hasKey(K key) {
        int hashCode = getHashcode(key);
        int hashIndex = hashCode % itemContainer.length;
        if (itemContainer[hashIndex] == null) {
            return false;
        } else {
            LinkedList<K, V> ll = itemContainer[hashIndex];
            return (ll.search(key) != null);
        }
    }

    /**
     * Remove the items from the hashmap with the associated key if present
     *
     * @param key to remove from hashmap
     * @return  associated value from key, or null if key not present
     */
    public V remove(K key) {
        int hashCode = getHashcode(key);
        int keyBin = hashCode % itemContainer.length;

        if (itemContainer[keyBin] == null) {
            return null;
        } else {
            V value = itemContainer[keyBin].search(key);
            if (value != null) {
                n--;

            }
            return value;
        }
    }

    // Get hash code just for purposes of understanding the process
    // rules of a hashCode() function:
    // 1. Invoking it more than once on the same object must consistantly return the same
    // integer, provided no info used in equals() is modified
    // 2. If two objects are equal according to equals(), then the same hashCode() must be returned
    // 3. It is not required that different objeccts return different hashCodes.
    // But the program must be aware and keep this in mind. see also pigeonhole principle
    private int getHashcode(K key) {
        return key.hashCode();
    }

    public int size() {
        return n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<K, V> ll : itemContainer) {
            if (ll == null) {
                continue;
            }
            sb.append(ll.toString());
        }
        return sb.toString();
    }






}
