package com.coding.TimeComplexity;

public class UniqueElement {
	public static int findUnique(int[] arr) {
		int unique=0;
		for (int i = 0; i < arr.length; i++) {
			unique=unique^arr[i];//6^6=0 XOR operator returns the unique element
		}
		return unique;
	}

	public static void main(String[] args) {
		int input[]= {2 ,3 ,1 ,6 ,3 ,6 ,2};
		System.out.println(findUnique(input));

	}

}