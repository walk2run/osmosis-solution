/*package com.osmosis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Solution2Bckup {
	public static void main(String[] args) {

	}

	static int getMostVisited(int n, int[] sprints) {
		List<Integer> integers = addToList(sprints);
		Map<Integer, Long> result = integers.stream().collect(java.util.stream.Collectors
				.groupingBy(java.util.function.Function.identity(), java.util.stream.Collectors.counting()));
		return Collections
				.max(result.entrySet(), (entry1, entry2) -> entry1.getValue().intValue() - entry2.getValue().intValue())
				.getKey();
	}

	static List<Integer> addToList(int[] sprints) {
		List<Integer> integers = new ArrayList<>();
		for (int i = 1; i < sprints.length; i++) {
			if (sprints[i - 1] < sprints[i]) {
				java.util.stream.IntStream.rangeClosed(sprints[i - 1], sprints[i]).forEach(s -> integers.add(s));
			} else {
				java.util.stream.IntStream.rangeClosed(sprints[i], sprints[i - 1]).forEach(s -> integers.add(s));
			}
		}
		return integers;
	}

}
*************88

static int getMostVisited(int n, int[] sprints) {
		List<Integer> integers = addToList(sprints);
		Map<Integer, Long> result = integers.stream()
				.collect(java.util.stream.Collectors.groupingBy(java.util.function.Function.identity(), java.util.stream.Collectors.counting()));
		return Collections
				.max(result.entrySet(), (entry1, entry2) -> entry1.getValue().intValue() - entry2.getValue().intValue())
				.getKey();
	}

	 static List<Integer> addToList(int[] sprints) {
		List<Integer> integers = new ArrayList<>();
		int j = 0;
		for (int i = 1; i < sprints.length; i++) {
			if (sprints[j] < sprints[i]) {
				java.util.stream.IntStream.rangeClosed(sprints[j], sprints[i]).forEach(s -> integers.add(s));
				j++;
			} else {
				java.util.stream.IntStream.rangeClosed(sprints[i], sprints[j]).forEach(s -> integers.add(s));
				j++;
			}
		}
		return integers;
	}

*/