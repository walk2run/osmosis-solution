package com.osmosis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, Arrays.stream(new int[] { 7, 3, 1, 7, 2, 0 }).boxed().toArray(Integer[]::new));

		System.out.println(list.removeAll(Arrays.asList(7, 3, 8)));
		System.out.println(list);
		System.out.println(maxPoints(new int[] { 7, 3, 1, 7, 2, 0 }));
	}

	static long maxPoints(int[] elements) {
		List<Integer> numbers = new ArrayList<Integer>();
		Collections.addAll(numbers, Arrays.stream(elements).boxed().toArray(Integer[]::new));
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		numbers.stream().forEach(s -> resultMap.put(s, 0));
		numbers.stream().forEach(s -> {
			int points = s;
			if (resultMap.containsKey(s)) {
				points = points + resultMap.get(s);
				resultMap.put(s, points);
			}
		});

		Map<Integer, Integer> result2 = new LinkedHashMap<>();
		resultMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
				.forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

		return removeNumbers(result2);
	}


	private static long removeNumbers(Map<Integer, Integer> map) {
		Map<Integer, Integer> tempMap = new LinkedHashMap<>(map);
		List<Integer> removal = new ArrayList<>();

		int maxPoints = 0;
		for (Integer key : map.keySet()) {
			if (!removal.contains(key)) {
				if (tempMap.containsKey(key + 1) || tempMap.containsKey(key - 1)) {
					removal.add(key + 1);
					removal.add(key - 1);
					tempMap.remove(key + 1);
					tempMap.remove(key - 1);
				}
			}
		}

		maxPoints = tempMap.values().stream().mapToInt(i -> i).sum();
		return maxPoints;
	}
}