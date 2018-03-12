package com.osmosis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution2 {
	/*
	 * Complete the function below.
	 */

	public static void main(String[] args) {
		int[] sprints = new int[] { 9, 7, 3,
				1/* 7, 3, 1, 7, 45, 87, 45, 7882, 4774, 10000, 37637, 1, 6, 8 */ };

		System.out.println(getMostVisited(sprints.length, sprints));
	}

	static int getMostVisited(int n, int[] sprints) {
		Map<Integer, Long> result = addToList(sprints);
		List<Long> values = result.values().stream().sorted().collect(Collectors.toList());
		values.get(values.size() - 1);
		return values.get(0).intValue();
	}

	static Map<Integer, Long> addToList(int[] sprints) {
		Map<Integer, Long> result = new TreeMap<>();
		List<Integer> sprintList = new ArrayList<>();
		for (int i = 1; i < sprints.length; i++) {
			sprintList.add(sprints[i - 1]);
			sprintList.add(sprints[i]);
			
			if (sprints[i - 1] < sprints[i]) {
				java.util.stream.IntStream.rangeClosed(sprints[i - 1], sprints[i]).forEach(s -> {
					if(sprintList.contains(s)){
						if (result.containsKey(s)) {
							result.put(s, (long) result.get(s) + 1);
						} else {
							result.put(s, (long) 1);
						}
					}});
			} else {
				java.util.stream.IntStream.rangeClosed(sprints[i], sprints[i - 1]).forEach(s -> {
					if(sprintList.contains(s)){
					if (result.containsKey(s)) {
						result.put(s, (long) result.get(s) + 1);
					} else {
						result.put(s, (long) 1);
					}
				}});
			}
		}
		return result;
	}

	/*
	 * static int maxRepeating(int arr[], int k) { int n = arr.length; for (int
	 * i = 0; i < n; i++) arr[(arr[i] % k)] += k;
	 * 
	 * int max = arr[0], result = 0; for (int i = 1; i < n; i++) { if (arr[i] >
	 * max) { max = arr[i]; result = i; System.out.println("result::" + max +
	 * "i val:" + i); } } System.out.println(result); return result; }
	 */
}