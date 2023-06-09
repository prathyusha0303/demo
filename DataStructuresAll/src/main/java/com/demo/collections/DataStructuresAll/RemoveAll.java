package com.demo.collections.DataStructuresAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class RemoveAll {

	public static void main(String[] args) {
		// Create instances of ArrayList, LinkedList, HashSet, TreeSet, HashMap, and
		// TreeMap
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		HashSet<Integer> hashSet = new HashSet<Integer>();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

		// Add elements to the data structures
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
			linkedList.add(i);
			hashSet.add(i);
			treeSet.add(i);
			hashMap.put(i, i);
			treeMap.put(i, i);
		}

		// Measure the time taken for the remove operation for each data structure
		// (ArrayList and LinkedList)
		long arrayListStartTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			arrayList.remove(0);
		}
		long arrayListEndTime = System.nanoTime();
		long arrayListTimeTaken = arrayListEndTime - arrayListStartTime;

		long linkedListStartTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			linkedList.remove(0);
		}
		long linkedListEndTime = System.nanoTime();
		long linkedListTimeTaken = linkedListEndTime - linkedListStartTime;

		// Measure the time taken for the remove operation for each data structure
		// (HashSet and TreeSet)
		long hashSetStartTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashSet.remove(i);
		}
		long hashSetEndTime = System.nanoTime();
		long hashSetTimeTaken = hashSetEndTime - hashSetStartTime;

		long treeSetStartTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			treeSet.remove(i);
		}
		long treeSetEndTime = System.nanoTime();
		long treeSetTimeTaken = treeSetEndTime - treeSetStartTime;

		// Measure the time taken for the remove operation for each data structure
		// (HashMap and TreeMap)
		long hashMapStartTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashMap.remove(i);
		}
		long hashMapEndTime = System.nanoTime();
		long hashMapTimeTaken = hashMapEndTime - hashMapStartTime;

		long treeMapStartTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			treeMap.remove(i);
		}
		long treeMapEndTime = System.nanoTime();
		long treeMapTimeTaken = treeMapEndTime - treeMapStartTime;

		// Calculate the approximate memory usage of each data structure
		long arrayListMemoryUsage = getMemoryUsage(arrayList);
		long linkedListMemoryUsage = getMemoryUsage(linkedList);
		long hashSetMemoryUsage = getMemoryUsage(hashSet);
		long treeSetMemoryUsage = getMemoryUsage(treeSet);
		long hashMapMemoryUsage = getMemoryUsage(hashMap);
		long treeMapMemoryUsage = getMemoryUsage(treeMap);

		// Display the time and memory usage for each data structure
		System.out.println("ArrayList time taken: " + arrayListTimeTaken + " ns");
		System.out.println("ArrayList memory usage: " + arrayListMemoryUsage + " bytes");

		System.out.println("LinkedList time taken: " + linkedListTimeTaken + " ns");
		System.out.println("LinkedList memory usage: " + linkedListMemoryUsage + " bytes");

		System.out.println("HashSet time taken: " + hashSetTimeTaken + " ns");
		System.out.println("HashSet memory usage: " + hashSetMemoryUsage + " bytes");

		System.out.println("TreeSet time taken: " + treeSetTimeTaken + " ns");
		System.out.println("TreeSet memory usage: " + treeSetMemoryUsage + " bytes");

		System.out.println("HashMap time taken: " + hashMapTimeTaken + " ns");
		System.out.println("HashMap memory usage: " + hashMapMemoryUsage + " bytes");

		System.out.println("TreeMap time taken: " + treeMapTimeTaken + " ns");
		System.out.println("TreeMap memory usage: " + treeMapMemoryUsage + " bytes");
	}

	private static long getMemoryUsage(Object object) {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		return runtime.totalMemory() - runtime.freeMemory();
	}
}
