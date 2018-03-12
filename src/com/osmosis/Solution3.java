package com.osmosis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
		int[] bundleQuantities = new int[] { 20, 19 };
		int[] bundleCosts = new int[] { 24, 20 };
		int result = budgetShopping(50, bundleQuantities, bundleCosts);
		System.out.println("no of books" + result);
	}

	static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
		int noOfBooks = 0;
		List<Store> stores = new ArrayList<>();
		for (int i = 0; i < bundleCosts.length; i++) {
			stores.add(new Store((float) bundleQuantities[i] / bundleCosts[i], bundleQuantities[i], bundleCosts[i]));
		}
		Collections.sort(stores, new Comparator<Store>() {
			@Override
			public int compare(Store o1, Store o2) {
				return o1.compareTo(o2);
			}
		});
		// stores = stores.stream().sorted((b1, b2) ->
		// b1.compareTo(b2)).collect(Collectors.toList());
		stores.stream().forEach(System.out::println);

		noOfBooks = purchaseBook(n, stores.toArray(new Store[stores.size()]));
		return noOfBooks;

	}

	static int purchaseBook(int amount, Store[] stores) {
		int noOfBooks = 0, temp;
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < stores.length; i++) {
			noOfBooks = 0;
			temp = amount;
			int minBundleCost = Arrays.asList(stores).stream().min((s2, s3) -> s2.getBundleCost() - s3.getBundleCost())
					.get().getBundleCost();
			int j = i;
			while (temp >= minBundleCost) {
				Store store = stores[j];
				noOfBooks = noOfBooks + (temp / store.getBundleCost()) * store.getBundleQuantitity();
				temp = temp % store.getBundleCost();
				j++;
			}
			results.add(noOfBooks);
		}
		System.out.println("rer" + results);

		return results.stream().max(Comparator.naturalOrder()).get();
	}

	static class Store implements Comparable<Store> {
		double booksPer$;

		public double getBooksPer$() {
			return booksPer$;
		}

		public void setBooksPer$(double booksPer$) {
			this.booksPer$ = booksPer$;
		}

		public int getBundleQuantitity() {
			return bundleQuantitity;
		}

		public void setBundleQuantitity(int bundleQuantitity) {
			this.bundleQuantitity = bundleQuantitity;
		}

		public int getBundleCost() {
			return bundleCost;
		}

		public void setBundleCost(int bundleCost) {
			this.bundleCost = bundleCost;
		}

		int bundleQuantitity;
		int bundleCost;

		public Store(double booksPer$, int bundleQuantitity, int bundleCost) {
			super();
			this.booksPer$ = booksPer$;
			this.bundleQuantitity = bundleQuantitity;
			this.bundleCost = bundleCost;
		}

		@Override
		public String toString() {
			return "Store [cPer$=" + booksPer$ + ", bundleQuantitity=" + bundleQuantitity + ", bundleCost=" + bundleCost
					+ "]";
		}

		@Override
		public int compareTo(Store other) {
			int compare = 0;// = Double.compare(this.getcPer$(),
							// other.getcPer$());
			if (compare == 0) {
				compare = Integer.compare(other.getBundleCost(), this.getBundleCost());
			}
			return compare;
		}

	}
}