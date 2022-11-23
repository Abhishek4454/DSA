package com.coding.recursionNew;

public class LastIndexofNumber {
	public static int lastIndex(int input[], int x) {

		return lastIndex(input,input.length-1,  x);
		
	}
	private static int lastIndex(int[] input, int lastIndex, int x) {
		
		if(lastIndex<=0)
			return -1;
		
		if(input[lastIndex]==x)
			return lastIndex;
		
		return lastIndex(input,lastIndex-1, x);
	}
	public static void main(String[] args) {
		
		int arr[]= {9 ,8 ,10 ,8};
		System.out.println(lastIndex(arr,8));


	}

}
