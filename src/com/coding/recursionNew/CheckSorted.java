package com.coding.recursionNew;

public class CheckSorted {

	public static boolean ifArraySorted(int arr[]) {
		
		if(arr.length<=1) {
			return true;
		}
		int newArr[]=new int[arr.length-1];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i]=arr[i+1];
		}
		
		if(arr[0]>newArr[0])
			return false;
		
		
		return ifArraySorted(newArr);
	}
	
	public static boolean ifArraySortedBetter(int arr[],int startIndex) {
		
		if(startIndex>=arr.length-1)
			return true;
		
		if(arr[startIndex]>arr[startIndex+1])
			return false;
		
		return ifArraySortedBetter(arr,startIndex+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int arr[]= {1,3,4,11,5,12};
		System.out.println(ifArraySorted(arr));
		System.out.println(ifArraySortedBetter(arr,0));

	}

}
