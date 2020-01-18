package com.yaroslav.behavioral.strategy;

import java.util.Arrays;

public class BubbleSort implements Sorting {
	@Override
	public void sort(int[] arr) {
		System.out.println("Bubble sort");
		System.out.println("before: \t" + Arrays.toString(arr));
		for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
			for (int i = 0; i < barrier; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
		System.out.println("After: \t" + Arrays.toString(arr));
	}
}
