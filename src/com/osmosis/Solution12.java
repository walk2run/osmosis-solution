package com.osmosis;

import java.util.Arrays;
import java.util.TreeMap;

public class Solution12 {
	static String decode(String[] codes, String encoded) {
		TreeMap<String, String> map = new TreeMap<>();
		Arrays.asList(codes).stream().forEach(code -> {
			map.put(code.split("\t")[1], code.split("\t")[0]);
		});

		String result = "";
		while (!encoded.isEmpty()) {
			for (String key : map.keySet()) {
				if (encoded.startsWith(key)) {
					encoded = encoded.substring(key.length());
					if (map.get(key).equals("[newline]")) {
						result = result + "\n";
					} else {
						result = result + map.get(key);
					}
				}
			}
		}
		return result;
	}
}
