package com.osmosis;

public class Solution7Bckup {

	public static void main(String[] args) {
		String a = "acbcaddeab", b = "aabbaccdde";
		System.out.println(easyStrings(a, b));
	}

	static int easyStrings(String a, String b) {
		if (a.length() != b.length()) {
			return 0;
		}
		char a1[] = a.toCharArray();
		char b1[] = b.toCharArray();
		
		int rCount = rightTraverse(a1, b1);
		int lCount = rightTraverse(b1, a1);
		return rCount >= lCount ? lCount : rCount;
	}

	
	private static int rightTraverse(char[] a1, char[] b1) {
		int count = 0;
		char[] a1Temp = a1.clone();
		for (int i = 0; i < a1Temp.length; i++) {
			char t;
			if (a1Temp[i] != b1[i]) { 
				int indexInA = String.valueOf(a1Temp).indexOf(b1[i]);
				t = a1Temp[i];
				a1Temp[i] = a1Temp[indexInA];
				a1Temp[indexInA] = t;
				count++;
			}
			System.out.print(a1Temp);
			System.out.print(" rr ");
			System.out.println(b1);

		}
		System.out.println("r count" + count);
		return count;
	}
}