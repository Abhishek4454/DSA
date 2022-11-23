package com.coding.TimeComplexity;

public class DuplicateInArray {
	public static int findDuplicate(int[] arr) {
		int sum=(arr.length-2)*(arr.length-1)/2;
		int actual_sum=0;
		for (int i = 0; i < arr.length; i++)
			actual_sum+=arr[i];
		
		return actual_sum-sum;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0 ,7 ,2 ,5 ,4 ,7 ,1 ,3 ,6};
      System.out.println(findDuplicate(arr));
	}

}
