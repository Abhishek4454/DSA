package com.coding.recursionNew;

public class FirstIndexofNumber {
	public static int firstIndex(int input[], int x) {

		return firstIndex(input,0,  x);
		
	}
	private static int firstIndex(int[] input, int startIndex, int x) {
		
		if(startIndex>=input.length-1)
			return -1;
		
		if(input[startIndex]==x)
			return startIndex;
		
		return firstIndex(input,startIndex+1, x);
	}
	public static void main(String[] args) {
		
		int arr[]= {9 ,8 ,10 ,8};
		System.out.println(firstIndex(arr,8));

	}

}
