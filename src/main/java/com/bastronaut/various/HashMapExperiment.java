package com.bastronaut.various;


import java.util.HashMap;

/**
 * Created by BSijtsma on 01-02-2017.
 *
 * Experiment with recreating a HashMap data structure:
 * - a Aey / value data structure
 * - Has fast (O(1) lookup through the use of 'bins' in which it stores an item
 * - The bin is based on the hashCode of the key
 * - Start with simple implementation of a HashMap
 */
public class HashMapExperiment <K, V> {

    String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
                        "i", "j" ,"k", "l", "m", "n", "o", "p", "q",
                        "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private Object[] itemContainer = new Object[16]; // default size for hashmap in Oracle Java I think
    private int n;



    public static void hashMapToString() {
        HashMap<String, String> testMap = new HashMap<>();
        testMap.put("name", "bas");
        testMap.put("surname", "henk");
        testMap.put("color", "Blue");
        System.out.println(testMap.toString());
    }

    public void put(K key, V value) {
        int hashCode = getHashcode(key);
        // the array size (number of bins) is smaller than the possible hashcode
        // use the modulus of the hascode to determine the bin
        int keyBin = hashCode
    }

    public V get(K key) {
        return null;
    }

    // Poor way to get a hash code just for purposes of understanding the process.
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
    public int getHashcode(K key) {
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

    public int size() {
        return 0; // TODO
    }

    private int getIndexInAlphabet(String letter) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(letter)) {
                return i;
            }
        }
        return alphabet.length + 1;
    }






}
