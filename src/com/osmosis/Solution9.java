package com.osmosis;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution9 {
	public static void main(String[] args) {
		int[][] maze = { { 0, 1, 2 }, { 0, 0, 1 }, { 1, 1, 1 } };
		System.out.println(maze.length);
		minMoves(maze, 1, 1);
	}

	private static final String RIGHT = "moveRight";
	private static final String LEFT = "moveLeft";
	private static final String UP = "moveUp";
	private static final String DOWN = "moveDown";

	static Map<Integer, Integer> obstacles = new LinkedHashMap<>();

	static List<String> cheeseLocations = new ArrayList<String>();

	static int moves = 0;
	static String direction = "";

	static int minMoves(int[][] maze, int x, int y) {
		System.out.println(maze.length);
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j] == 1) {
					obstacles.put(Integer.valueOf(i + "" + j), 1);
				}
				if (maze[i][j] == 2) {
					if (checkAvailability(i, j, maze) && checkAvailability(j, i, maze)) {
						cheeseLocations.add(i + "" + j);
					}
				}
			}
		}
		System.out.println(cheeseLocations);
		// makeMoves(maze, x, y);
		return 0;
	}

	private static boolean checkAvailability(int i, int j, int[][] maze) {
		if (i > 0 && j > 0) {
			if (maze[i + 1][j] == 1 || maze[i - 1][j] == 1 || maze[i][j + 1] == 1 || maze[i][j - 1] == 1) {
				return false;
			}
		} else if (i == maze.length - 1 && j == 0) {
			if (maze[i - 1][j] == 1 || maze[i][j + 1] == 1) {
				return false;
			}
		} else if (j == 0 && i == 0) {
			if (maze[i + 1][j] == 1 || maze[i][j + 1] == 1) {
				return false;
			}
		} else if (i == maze.length - 1 && j == maze.length - 1) {
			if (maze[i][j - 1] == 1 || maze[i - 1][j] == 1) {
				return false;
			}
		} else if (i == 0 && j > 0) {
			if (maze[i][j - 1] == 1 || maze[i][j + 1] == 1 || maze[i + 1][j] == 1) {
				return false;
			}
		} else if (i == maze.length - 1 && j > 0) {
			if (maze[i][j - 1] == 1 || maze[i][j + 1] == 1 || maze[i + 1][j] == 1) {
				return false;
			}
		}
		return true;
	}

	private static void makeMoves(int[][] maze, int x, int y) {
		int locCount = 0;
		int cheeseX, cheeseY, i = 0, j = 0;
		while (!cheeseLocations.isEmpty()) {
			cheeseX = cheeseLocations.get(locCount).charAt(0);
			cheeseY = cheeseLocations.get(locCount).charAt(1);
			if (cheeseY > i) {
				direction = Solution9.RIGHT;
				moveRight(i, j, maze);
			}
			if (cheeseX > i) {
				direction = Solution9.DOWN;
				moveDown(i, j, maze);
			}
			if (cheeseX < i) {
				direction = Solution9.UP;
				moveUp(i, j, maze);
			}
			if (cheeseY < i) {
				direction = Solution9.LEFT;
				moveLeft(i, j, maze);
			}
			locCount++;
		}
	}

	private static void moveRight(int i, int j, int[][] maze) {
		if (maze[i][j] == 2) {
			// collect cheese
			cheeseLocations.remove(i + "" + j);
		}
		if (maze[i][j + 1] == 1) {
			moveDown(i, j, maze);
		}
		moves++;
		j++;
	}

	private static void moveLeft(int i, int j, int[][] maze) {

	}

	private static void moveUp(int i, int j, int[][] maze) {

	}

	private static void moveDown(int i, int j, int[][] maze) {
		j++;
		if (direction.equals(Solution9.RIGHT)) {
			moveRight(i, j, maze);
		}
	}

}
