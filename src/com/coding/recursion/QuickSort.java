package com.coding.recursion;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] input, int startIndex, int endInedx) {
		if(startIndex>=endInedx)
			return;
		int pivot=partition(input,startIndex,endInedx);
		
		quickSort(input, startIndex, pivot-1);
		quickSort(input, pivot+1, endInedx);
		

		
	}

	private static int partition(int[] arr, int start, int end) {
		  
		    int pivot = arr[end]; 
	        int i = (start-1); // index of smaller element
	        for (int j=start; j<end; j++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (arr[j] <= pivot)
	            {
	                i++;
	  
	                // swap arr[i] and arr[j]
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	                
	            }
	        }
	  
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arr[i+1];
	        arr[i+1] = arr[end];
	        arr[end] = temp;
	  
	        return i+1;
	}
//		int count=0;
//
//		for (int k = 1; k < input.length && input[0]>input[k]; k++)
//			count++;
//		
//		int pivot=startIndex+count;
//		int i=startIndex;
//		int j=pivot+1;
//		
//		while(i<=pivot-1 && j<=endInedx)
//		{
//			if(input[i]>input[pivot] && input[j]<input[pivot])
//			{
//				int temp=input[i];
//				input[i]=input[j];
//				input[j]=temp;
//				i++;
//				j++;
//			}
//			if(input[i]>input[pivot] && input[j]>input[pivot])
//				j++;
//			if(input[i]<input[pivot] && input[j]<input[pivot])
//				j++;
//			if(input[i]<input[pivot] && input[j]>input[pivot])
//				{
//				  i++;
//				  j++;
//				}
//			
//		}
//		
//		
//		
//		return pivot;
//	}

	public static void quickSort(int[] input) {
		quickSort(input, 0, input.length - 1);
	}
	public static void main(String[] args) {
		int input[]= {2 ,6 ,8 ,5 ,4 ,3};
		quickSort(input);
        System.out.println(Arrays.toString(input));

	}

}
