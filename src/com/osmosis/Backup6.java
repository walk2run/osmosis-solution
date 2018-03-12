package com.osmosis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Backup6 {

	/*
	 * Complete the function below.
	 */
	static int[] adorableCount(String[] words) {

		String pattern = "[a-z][a-z\\d:]*\\/[a-z\\d]+\\\\[a-z]+";
		Pattern r = Pattern.compile(pattern);
		int array[] = new int[words.length];
		

		for (int i = 0; i < words.length; i++) {
			
			Matcher m = r.matcher(words[i]);
			int from = 0;
			while (m.find(from)) {
				array[i]++;
				from = m.start() + 1;
				int end = m.end();
				
				end--;
				end--;
				while (end > 0 && words[i].charAt(end) <= 'z' && words[i].charAt(end) >= 'a') {
					array[i]++;
					end--;
				}

			}

		}
		return array;
	}
}
