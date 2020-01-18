package com.yaroslav.behavioral.strategy;

import java.util.Arrays;

public class InsertionSort implements Sorting {

	@Override
	public void sort(int[] arr) {
		System.out.println("Insertion sort");
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
