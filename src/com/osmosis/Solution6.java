package com.osmosis;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution6 {
	public static void main(String[] args) {

	}

	/*
	 * Complete the function below.
	 */
	static int[] adorableCount(String[] words) {

		String regexPattern = "[a-z][a-z\\d:]*\\/[a-z\\d]+\\\\[a-z]+";
		Pattern r = Pattern.compile(regexPattern);
		int array[] = new int[words.length];
		java.util.concurrent.atomic.AtomicInteger counter = new java.util.concurrent.atomic.AtomicInteger(0);
		Arrays.asList(words).stream().forEach(word -> {
			Matcher m = r.matcher(word);
			int from = 0;
			while (m.find(from)) {
				array[counter.get()]++;
				from = m.start() + 1;
				int last = m.end();
				last--;
				last--;
				while (last > 0 && word.charAt(last) <= 'z' && word.charAt(last) >= 'a') {
					array[counter.get()]++;
					last--;
				}

			}
			counter.getAndIncrement();
		});
		return array;
	}
}
