package com.coding.recursionNew;

public class AllIndicesofNumber {
	public static int[] allIndexes(int input[], int x) {

		return allIndexes(input, x, 0);
	}
	
	private static int[] allIndexes(int[] input, int x, int startIndex) {
		
		
		if(startIndex>input.length-1)
		{
			int empty[]=new int[0];
			return empty;
		}
		
		if(input[startIndex]==x)
		  System.out.print(startIndex+" ");
		
		return allIndexes(input,x, startIndex+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {9 ,8 ,10 ,8 ,8};
       System.out.println(allIndexes(arr, 8));
	}

}
