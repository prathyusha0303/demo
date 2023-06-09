package com.demo.collections.DataStructuresAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class GetAll {

	/**
	 * Get operation on Arraylist and LinkedList,
	 * Hashset and treeset,
	 * HashMap and TreeMap
	 * */
    public static void main(String[] args) {
        // Create instances of ArrayList, LinkedList, HashSet, TreeSet, HashMap, and TreeMap
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        // Populate the data structures with 100,000 elements
        int n = 100000;
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
            hashSet.add(i);
            treeSet.add(i);
            hashMap.put(i, i);
            treeMap.put(i, i);
        }

        // Measure the time taken for the all data structures
        long startTime, endTime, elapsedTime;
        int index = n - 1; // Get the last element
        int element;

        // ArrayList
        startTime = System.nanoTime();
        element = arrayList.get(index);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList - Get Time: " + elapsedTime + " ns");

        // LinkedList
        startTime = System.nanoTime();
        element = linkedList.get(index);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList - Get Time: " + elapsedTime + " ns");

        // HashSet
        startTime = System.nanoTime();
        boolean containsHashSet = hashSet.contains(index);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("HashSet - Get Time: " + elapsedTime + " ns");

        // TreeSet
        startTime = System.nanoTime();
        boolean containsTreeSet = treeSet.contains(index);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("TreeSet - Get Time: " + elapsedTime + " ns");

        // HashMap
        startTime = System.nanoTime();
        element = hashMap.get(index);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("HashMap - Get Time: " + elapsedTime + " ns");

        // TreeMap
        startTime = System.nanoTime();
        element = treeMap.get(index);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("TreeMap - Get Time: " + elapsedTime + " ns");

        // Calculate the approximate memory usage of each data structure after the get operation
        long arrayListMemory = getMemoryUsage(arrayList);
        long linkedListMemory = getMemoryUsage(linkedList);
        long hashSetMemory = getMemoryUsage(hashSet);
        long treeSetMemory = getMemoryUsage(treeSet);
        long hashMapMemory = getMemoryUsage(hashMap);
        long treeMapMemory = getMemoryUsage(treeMap);

        System.out.println("Approximate Memory Usage:");
        System.out.println("ArrayList: " + arrayListMemory + " bytes");
        System.out.println("LinkedList: " + linkedListMemory + " bytes");
        System.out.println("HashSet: " + hashSetMemory + " bytes");
        System.out.println("TreeSet: " + treeSetMemory + " bytes");
        System.out.println("HashMap: " + hashMapMemory + " bytes");
        System.out.println("TreeMap: " + treeMapMemory + " bytes");
    }

    // Helper method to calculate the approximate memory usage of an object
    private static long getMemoryUsage(Object object) {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}


