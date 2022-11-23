package com.coding.recursionNew;

public class SumofArray {

	public static int sum(int input[]) {
		
		if (input.length < 1) {
			return 0;
		}

		int temp[] = new int[input.length - 1];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = input[i + 1];
		}

		return input[0] + sum(temp);
		
	}
	
	public static void main(String[] args) {
		int arr[]= {3,8,9};
		System.out.println(sum(arr));

	}

}
