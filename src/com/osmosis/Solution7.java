package com.osmosis;

public class Solution7 {

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
		String ab = deleteRedundant(a1, b1);
		a1 = ab.substring(0, ab.indexOf("_")).toCharArray();
		b1 = ab.substring(ab.indexOf("_") + 1).toCharArray();

		int rCount = rightTraverse(a1, b1);
		int lCount = rightTraverse(b1, a1);
		return rCount >= lCount ? lCount : rCount;
	}

	private static String deleteRedundant(char[] a, char[] b) {

		String aTemp = "";
		String bTemp = "";

		for (int i = 0; i < b.length; i++) {
			if (a[i] != b[i]) {
				aTemp = aTemp + a[i];
				bTemp = bTemp + b[i];
			}
		}
		return aTemp + "_" + bTemp;
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

	/*
	 * private static int leftTraverse(String a, String b) { a = new
	 * StringBuilder(a).reverse().toString(); char a1[] = a.toCharArray(); char
	 * b1[] = b.toCharArray();
	 * 
	 * int i = 0; int count = 0; while
	 * (!String.valueOf(a1).equals(String.valueOf(b1))) { char t; if (a1[i] !=
	 * b1[i]) { int indexInA = String.valueOf(a1).indexOf(b1[i]); t = a1[i];
	 * a1[i] = a1[indexInA]; a1[indexInA] = t; count++; } i++;
	 * System.out.print(a1); System.out.print(" ll"); System.out.println(b1); }
	 * System.out.println(" count"+count);
	 * 
	 * return count; }
	 */
}
/*
 * char a1[] = a.toCharArray(); char b1[] = b.toCharArray();
 * 
 * int i = 0; while (!String.valueOf(a1).equals(String.valueOf(b1))) { char t;
 * if (a1[i] != b1[i]) { int indexInA = a.indexOf(b1[i]); t = a1[i]; a1[i] =
 * a1[indexInA]; a1[indexInA] = t; } i++; System.out.println(a1); }
 */