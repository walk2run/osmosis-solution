package com.osmosis;

import java.util.HashMap;
import java.util.HashSet;

public class Solution11 {
	public static void main(String[] args) {

	}

	public static int minimalCost(int n, String[] pairs) {
		HashMap<String, HashSet<String>> rodsMap = new HashMap<String, HashSet<String>>();
		HashSet<String> lonely = new HashSet<String>();
		for (int i = 0; i < pairs.length; i++) {
			String current = pairs[i];
			String[] tmp = current.split(" ");
			String p = Integer.parseInt(tmp[0]) <= Integer.parseInt(tmp[1]) ? tmp[0] : tmp[1];
			String q = Integer.parseInt(tmp[0]) <= Integer.parseInt(tmp[1]) ? tmp[1] : tmp[0];
			lonely.add(p);
			lonely.add(q);
			HashSet<String> setP = new HashSet<String>();
			int p_i = -1;
			int q_i = -1;
			HashSet<String> setQ = new HashSet<String>();
			for (int t = n; t >= 1; t--) {
				if (rodsMap.containsKey(String.valueOf(t))) {
					if (rodsMap.get(String.valueOf(t)).contains(q)) {
						setQ = rodsMap.get(String.valueOf(t));
						q_i = t;
					}
					if (rodsMap.get(String.valueOf(t)).contains(p)) {
						setP = rodsMap.get(String.valueOf(t));
						p_i = t;
					}
				}
			}
			if (q_i == -1 && p_i == -1) {
				HashSet<String> hs = new HashSet<String>();
				hs.add(p);
				hs.add(q);
				rodsMap.put(p, hs);
				continue;
			}
			if (q_i == -1 && p_i != -1) {
				setP.add(q);
				if (Integer.valueOf(p) < p_i) {
					rodsMap.put(p, setP);
					rodsMap.remove(String.valueOf(p_i));
				} else {
					rodsMap.put(String.valueOf(p_i), setP);
				}
				continue;
			}
			if (q_i != -1 && p_i == -1) {
				setQ.add(p);
				if (Integer.valueOf(p) < q_i) {
					rodsMap.put(p, setQ);
					rodsMap.remove(String.valueOf(q_i));
				} else {
					rodsMap.put(String.valueOf(q_i), setQ);
				}
				continue;
			}
			if (q_i != -1 && p_i != -1) {
				if (q_i < p_i) {
					HashSet<String> hs = rodsMap.get(String.valueOf(q_i));
					hs.addAll(rodsMap.get(String.valueOf(p_i)));
					rodsMap.put(String.valueOf(q_i), hs);
					rodsMap.remove(String.valueOf(p_i));
				} else {
					HashSet<String> hs = rodsMap.get(String.valueOf(p_i));
					hs.addAll(rodsMap.get(String.valueOf(q_i)));
					rodsMap.remove(String.valueOf(q_i));
					rodsMap.put(String.valueOf(p_i), hs);
				}
				continue;
			}
		}
		int sum = 0;
		for (java.util.Map.Entry<String, HashSet<String>> entry : rodsMap.entrySet()) {
			String key = entry.getKey();
			HashSet<String> value = entry.getValue();
			sum += (int) Math.ceil(Math.sqrt(value.size()));
		}
		sum = sum + n - lonely.size();
		return sum;
	}
}
