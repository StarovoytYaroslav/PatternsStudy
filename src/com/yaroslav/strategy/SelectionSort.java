package com.yaroslav.strategy;

import java.util.Arrays;

public class SelectionSort implements Sorting {

	@Override
	public void sort(int[] arr) {
		System.out.println("Selection sort");
		System.out.println("before: \t" + Arrays.toString(arr));
		for (int barrier = 0; barrier < arr.length - 1; barrier++) {
			for (int i = barrier + 1; i < arr.length; i++) {
				if (arr[i] > arr[barrier]) {
					int tmp = arr[i];
					arr[i] = arr[barrier];
					arr[barrier] = tmp;
				}
			}
		}
		System.out.println("After: \t" + Arrays.toString(arr));
	}

}
