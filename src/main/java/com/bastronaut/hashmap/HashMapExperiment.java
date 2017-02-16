package com.bastronaut.hashmap;


import com.bastronaut.linkedlist.LinkedList;
import com.sun.istack.internal.Nullable;

import java.util.HashMap;

/**
 * Created by BSijtsma on 01-02-2017.
 *
 * Experiment with recreating a HashMap data structure:
 * - a Key / value data structure
 * - Has fast (O(1) lookup through the use of 'bins' in which it stores an value
 * (O(1) is assuming proper initialization with size and load factor)
 * - The bin is based on the hashCode of the key
 * - Start with simple implementation of a HashMap
 */
public class HashMapExperiment <K, V> {

    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
                        "i", "j" ,"k", "l", "m", "n", "o", "p", "q",
                        "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private int n;

    //  a more advanced implementation would allow to set initial size and load factor for resizing
    private LinkedList<K, V>[] itemContainer = new LinkedList[16]; // default size for hashmap in Oracle Java


    public void put(K key, V value) {
        int hashCode = getHashcode(key);
        // Storing as a linkedlist
        int keyBin = hashCode % itemContainer.length;
        if (itemContainer[keyBin] == null) {
            LinkedList<K, V> ll = new LinkedList<K, V>();
            ll.push(key, value);
            itemContainer[keyBin] = ll;
        } else {
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

    // Poor way to get a hash code just for purposes of understanding the process
    // rules of a hashCode() function:
    // 1. Invoking it more than once on the same object must consistantly return the same
    // integer, provided no info used in equals() is modified
    // 2. If two objects are equal according to equals(), then the same hashCode() must be returned
    // 3. It is not required that different objeccts return different hashCodes.
    // But the program must be aware and keep this in mind. see also pigeonhole principle
    // Example hashCode algo:
    // 1. take the first character, get the letter index from the alphabet.
    // 2. take the last character, get the letter index from the alphabet.
    // 3. take the middle character, get the letter index from the alphabet.
    // If the characters are not present in the alphabet, take alphabetsize + 1
    // sum these ints -> hashcode.
    private int getHashcode(K key) {
        String lowercaseKey = key.toString().toLowerCase();
        if (lowercaseKey.length() == 0) {
            return alphabet.length + 1;
        }
        String firstLetter = lowercaseKey.substring(0, 1);
        String midLetter = lowercaseKey.substring(lowercaseKey.length() / 2,  lowercaseKey.length() / 2 + 1);
        String lastLetter = lowercaseKey.substring(lowercaseKey.length() -1, lowercaseKey.length());
        int firstLetterIndex = getIndexInAlphabet(firstLetter);
        int midLetterIndex = getIndexInAlphabet(midLetter);
        int lastLetterindex = getIndexInAlphabet(lastLetter);
        return firstLetterIndex + midLetterIndex + lastLetterindex;
    }


    private int getIndexInAlphabet(String letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(letter)) {
                return i;
            }
        }
        return alphabet.length + 1;
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
