package com.arrayprolc.gametech.java.leaderboards.util;

import java.util.ArrayList;

public class UtilMenu {

	private static int[] lastEmptySlots = null;
	private static int[] lastAllowedSlots = null;

	/**
	 * Get the empty slots in an inventory (sides and top). Calculates once and
	 * then uses it from memory once it's been calculated once.
	 * 
	 * @return a list of slots that are allowed.
	 */
	public static int[] getEmptySlots() {
		if (lastEmptySlots != null) {
			return lastEmptySlots;
		}
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++)
			ints.add(i);
		for (int i = 45; i <= 53; i++)
			ints.add(i);
		int i2 = 0;
		while (i2 <= 36) {
			i2 = i2 + 9;
			if (!ints.contains(i2)) {
				ints.add(i2);
			}
		}
		int i3 = 8;
		while (i3 <= 44) {
			i3 = i3 + 9;
			if (!ints.contains(i3)) {
				ints.add(i3);
			}
		}
		int[] i4 = new int[ints.size()];
		int i6 = 0;
		for (@SuppressWarnings("unused")
		int i5 : ints) {
			i4[i6] = ints.get(i6).intValue();
			i6++;
		}
		lastEmptySlots = i4;
		return i4;
	}

	/**
	 * Get the allowed slots in inventory (*not* the top and sides). Calculates
	 * once and then uses it from memory once it's been calculated once.
	 * 
	 * @see Max per page is 6 rows!
	 * 
	 * @return a list of slots that are allowed.
	 */
	public static int[] getAllowedSlots() {
		if (lastAllowedSlots != null) {
			return lastAllowedSlots;
		}
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < 9 * 6; i++) {
			if (!isBlocked(i)) {
				ints.add(i);
			}
		}

		int[] i4 = new int[ints.size()];
		int i6 = 0;
		for (@SuppressWarnings("unused")
		int i5 : ints) {
			i4[i6] = ints.get(i6).intValue();
			i6++;
		}
		lastAllowedSlots = i4;
		return i4;
	}

	/**
	 * Sees if a slot is blocked.
	 * 
	 * @see getEmptySlots()
	 * 
	 * @param i
	 *            The value you want to test
	 * 
	 * @return if "i" is allowed
	 */
	public static boolean isBlocked(int i) {
		for (int i2 : getEmptySlots()) {
			if (i2 == i) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the amount of pages something will take up
	 * 
	 * @see getEmptySlots()
	 * 
	 * @param amount
	 *            The amount of items you want to use.
	 * 
	 * @return the amount of pages
	 */
	public int amountOfPages(int amount) {
		int i = amount / getAllowedSlots().length;
		if (amount % getAllowedSlots().length != 0)
			i++;
		return i;

	}

}
