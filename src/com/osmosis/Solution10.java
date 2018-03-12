package com.osmosis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution10 {
	public static void main(String[] args) {

	}

	static ArrayList<Integer[]> getNext(int x, int y, int arr[][]) {
		int maximumX = arr.length;
		int maximumY = arr[0].length;
		ArrayList<Integer[]> list = new ArrayList<>();

		if (x - 1 >= 0) {
			Integer tmp[] = new Integer[2];
			tmp[0] = x - 1;
			tmp[1] = y;
			if (arr[tmp[0]][tmp[1]] == 1)
				list.add(tmp);
		}

		 if (x + 1 < maximumX) {
			Integer tmp[] = new Integer[2];
			tmp[0] = x + 1;
			tmp[1] = y;
			if (arr[tmp[0]][tmp[1]] == 1)
				list.add(tmp);
		}

		 if (y - 1 >= 0) {
			Integer tmp[] = new Integer[2];
			tmp[0] = x;
			tmp[1] = y - 1;
			if (arr[tmp[0]][tmp[1]] == 1)
				list.add(tmp);
		}  if (y + 1 < maximumY) {
			Integer tmp[] = new Integer[2];
			tmp[0] = x;
			tmp[1] = y + 1;
			if (arr[tmp[0]][tmp[1]] == 1)
				list.add(tmp);
		}
		return list;
	}

	static long getFactorial(int n, int r) {
		if (r > n / 2)
			r = n - r;
		long ans = 1;
		int i;

		for (i = 1; i <= r; i++) {
			ans *= n - r + i;
			ans /= i;
		}

		return ans;
	}

	static int Group(String[] grid) {
		int arr[][] = new int[grid.length][grid[0].length()];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {
				if (grid[i].charAt(j) == 'N') {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}
		int count = 0;
		Queue<Integer[]> dataQueue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {

				if (arr[i][j] == 1) {
					count++;
					ArrayList<Integer[]> list = getNext(i, j, arr);
					arr[i][j] = 2;
					dataQueue.addAll(list);
					while (dataQueue.size() != 0) {
						Integer xy[] = dataQueue.remove();
						list = getNext(xy[0], xy[1], arr);
						arr[xy[0]][xy[1]] = 2;
						dataQueue.addAll(list);
					}
				}

			}
		}
		int ncrVal = 0;
		for (int i = 0; i < count; i += 2) {
			ncrVal += getFactorial(count, i);
			ncrVal = ncrVal % 1000000007;
		}

		return ncrVal;
	}
}
