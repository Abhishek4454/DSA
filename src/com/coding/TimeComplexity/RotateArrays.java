package com.coding.TimeComplexity;

import java.util.Arrays;

public class RotateArrays {

    public static void rotate(int[] arr, int d) {
//    	if(arr.length<d)
//    		return;
//    	
//    	for (int i = 0; i < d; i++) {
//			rotateByOne(arr);
//		}
//    }
//	private static void rotateByOne(int[] arr) {
//		
//		int temp=arr[arr.length-1];
//		for (int i = 0; i < arr.length-1; i++) {
//			arr[i]=arr[i+1];
//		}
//		arr[0]=temp;
    	
    	int temp[]=new int[d];
		int count=0;
		for (int i = 0; i < d; i++)
			temp[i]=arr[i];
		
		
		for (int i = 0; i < arr.length-d; i++)
			arr[i]=arr[i+d];
		
		for (int i = arr.length-d; i < arr.length; i++)
			arr[i]=temp[count++];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int arr[]= {1 ,2 ,3 ,4 ,5 ,6 ,7};
      rotate(arr, 2);
      System.out.println(Arrays.toString(arr));
      
	}

}
