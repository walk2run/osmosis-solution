package com.osmosis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution8 {
	public static void main(String[] args) {
		String[] operations = new String[] { "push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1", "pop", "push 1",
				"inc 2 2", "push 4", "pop", "pop" };
		superStack(operations);
		superStack2(operations);
	}

	static void superStack(String[] operations) {
		long t1 = System.currentTimeMillis();
		List<Integer> stack = new LinkedList<>();

		Arrays.asList(operations).stream().forEach(s -> {
			int value, incCount;
			String[] temp;
			switch (s.split(" ")[0]) {
			case "push":
				value = Integer.valueOf(s.substring(5, s.length()));
				stack.add(value);
				System.out.println(stack.isEmpty() ? "EMPTY" : stack.get(stack.size() - 1));
				break;
			case "pop":
				stack.remove(stack.size() - 1);
				System.out.println(stack.isEmpty() ? "EMPTY" : stack.get(stack.size() - 1));
				break;
			case "inc":
				temp = s.split(" ");
				incCount = Integer.valueOf(temp[1]);
				int value1 = Integer.valueOf(temp[2]);

				/*
				 * stack.subList(0, incCount).stream().forEach(t ->{ t=t +
				 * value1; }).collect(Collectors.toList());
				 */

				for (int j = 0; j < incCount; j++) {
					stack.set(j, stack.get(j) + value1);
				}

				System.out.println(stack.isEmpty() ? "EMPTY" : stack.get(stack.size() - 1));
				break;
			}
		});
		System.out.println("Array List "+(System.currentTimeMillis()-t1 ));
	}

	static void superStack2(String[] operations) {
		long t1 = System.currentTimeMillis();

		Stack<Integer> stack = new Stack<Integer>();

		Arrays.asList(operations).stream().forEach(s -> {
			int value, incCount;
			String[] temp;
			switch (s.split(" ")[0]) {
			case "push":
				value = Integer.valueOf(s.substring(5, s.length()));
				stack.push(value);
				System.out.println(stack.isEmpty() ? "EMPTY" : stack.get(stack.size() - 1));
				break;
			case "pop":
				stack.pop();
				System.out.println(stack.isEmpty() ? "EMPTY" : stack.get(stack.size() - 1));
				break;
			case "inc":
				temp = s.split(" ");
				incCount = Integer.valueOf(temp[1]);
				int value1 = Integer.valueOf(temp[2]);

				/*
				 * stack.subList(0, incCount).stream().forEach(t ->{ t=t +
				 * value1; }).collect(Collectors.toList());
				 */

				for (int j = 0; j < incCount; j++) {
					stack.set(j, stack.get(j) + value1);
				}

				System.out.println(stack.isEmpty() ? "EMPTY" : stack.get(stack.size() - 1));
				break;
			}
		});
		System.out.println("Stack "+(System.currentTimeMillis()-t1 ));

	}

}
