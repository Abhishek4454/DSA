package com.coding.recursionNew;

//Given an integer sorted array (sorted in increasing order) and an element x, find the x in given array using binary search. Return the index of x.
//Return -1 if x is not present in the given array.
//Note : If given array size is even, take first mid.
//Input format :
//
//Line 1 : Array size
//
//Line 2 : Array elements (separated by space)
//
//Line 3 : x (element to be searched)
//
//Sample Input :
//6
//2 3 4 5 6 8 
//5 
//Sample Output:
//3 
public class BinarySearch {
	public static int binarySearch(int input[], int element) {
		
		return helper(input,0,input.length-1,element);
		
	}
	private static int helper(int[] input, int start, int end, int element) {
		// TODO Auto-generated method stub
		
		if(start>end)
			return -1;
		int mid=(start+end)/2;
		
		if(input[mid]==element)
			return mid;
		
		else if(input[mid]>element)
			return helper(input,start, mid-1, element);
		else
			return helper(input, mid+1,end, element);
		
		
//		 if(start>end)
//				return -1;
//			
//			int mid=(start+end)/2;
//			
//			if(element==input[mid])
//				return mid;
//			else if(element>input[mid])
//				return helper(input,element,mid+1,end);
//			else
//				return helper(input,element,start,mid-1);
		
		
	}
	public static void main(String[] args) {
		int arr[]= {2, 3, 4, 5, 6, 8};
		System.out.println(binarySearch(arr, 6));
    
	}

}
