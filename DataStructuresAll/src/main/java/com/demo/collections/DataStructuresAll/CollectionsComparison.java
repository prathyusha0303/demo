package com.demo.collections.DataStructuresAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsComparison {

	public static void main(String[] args) {
		/**
		 * Addition operation on Arraylist and LinkedList,
		 * Hashset and treeset,
		 * HashMap and TreeMap
		 * */
		// ArrayList vs. LinkedList
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long arrayListTime = endTime - startTime;

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		long linkedListTime = endTime - startTime;

		long arrayListMemory = measureMemoryUsage(arrayList);
		long linkedListMemory = measureMemoryUsage(linkedList);

		System.out.println("Insertion operation for ArrayList vs. LinkedList");
		System.out.println("ArrayList insert Time : " + arrayListTime + " ns");
		System.out.println("LinkedList insert Time : " + linkedListTime + " ns");
		System.out.println("ArrayList Memory Usage : " + arrayListMemory + " bytes");
		System.out.println("LinkedList Memory Usage : " + linkedListMemory + " bytes");

		// HashSet vs. TreeSet
		HashSet<Integer> hashSet = new HashSet<Integer>();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashSet.add(i);
		}
		endTime = System.nanoTime();
		long hashSetTime = endTime - startTime;

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			treeSet.add(i);
		}
		endTime = System.nanoTime();
		long treeSetTime = endTime - startTime;

		long hashSetMemory = measureMemoryUsage(hashSet);
		long treeSetMemory = measureMemoryUsage(treeSet);

		System.out.println("\nInsertion operation for HashSet vs. TreeSet");
		System.out.println("HashSet insert Time : " + hashSetTime + " ns");
		System.out.println("TreeSet insert Time : " + treeSetTime + " ns");
		System.out.println("HashSet Memory Usage : " + hashSetMemory + " bytes");
		System.out.println("TreeSet Memory Usage : " + treeSetMemory + " bytes");

		// HashMap vs. TreeMap
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashMap.put(i, i);
		}
		endTime = System.nanoTime();
		long hashMapTime = endTime - startTime;

		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			treeMap.put(i, i);
		}
		endTime = System.nanoTime();
		long treeMapTime = endTime - startTime;

		long hashMapMemory = measureMemoryUsage(hashMap);
		long treeMapMemory = measureMemoryUsage(treeMap);

		System.out.println("\nInsertion operation for HashMap vs. TreeMap");
		System.out.println("HashMap insert Time : " + hashMapTime + " ns");
		System.out.println("TreeMap insert Time : " + treeMapTime + " ns");
		System.out.println("HashMap Memory Usage : " + hashMapMemory + " bytes");
		System.out.println("TreeMap Memory Usage : " + treeMapMemory + " bytes");
	}

	public static long measureMemoryUsage(Object obj) {
		// Calculate the approximate memory usage of an object
		long memory = 0;
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.gc();
			memory = runtime.totalMemory() - runtime.freeMemory();
			runtime.gc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memory;
	}
	
	
}
