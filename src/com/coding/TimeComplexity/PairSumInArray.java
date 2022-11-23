package com.coding.TimeComplexity;

import java.util.Arrays;

public class PairSumInArray {
	public static int pairSum(int[] arr, int num) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] + arr[j] == num)

					count++;

			}
		}

		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1, 3, 6, 2, 5, 4, 3, 2, 4};
     System.out.println(pairSum(arr, 7));
	}

}
