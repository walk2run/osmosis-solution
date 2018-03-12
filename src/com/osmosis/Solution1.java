package com.osmosis;

public class Solution1 {
	static int moves;

	public static void main(String[] args) {
		int[] avg = new int[] { 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 };
		System.out.println(minMoves(avg));
	}


	static int minMoves(int[] avg) {
		int leftMoves = getLeftMoves(avg);
		int rightMoves = getRightMoves(avg);
		if (rightMoves >= leftMoves) {
			return leftMoves;
		}
		return rightMoves;
	}

	static int getLeftMoves(int[] avg) {
		int moves = 0, lastIndex = 0;
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] == 1) {
				moves = moves + (i - lastIndex);
				lastIndex++;
			}
		}
		return moves;
	}

	static int getRightMoves(int[] avg) {
		int moves = 0, lastIndex = 0;
		for (int i = 0; i < avg.length; i++) {
			if (avg[i] == 0) {
				moves = moves + (i - lastIndex);
				lastIndex++;
			}
		}
		return moves;
	}


}