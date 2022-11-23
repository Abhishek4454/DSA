package com.coding.TimeComplexity;

import java.util.Arrays;

public class TripletSum {
	public static int tripletSum(int[] arr, int sum) {

		int count = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++)
					if (arr[i] + arr[j] + arr[k] == sum) {
						count++;
						// System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					}

			}

		}
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
	}

}
