package com.coding.recursion;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] input){
      
		mergeSort(input,0,input.length-1);
		
	}
	
	private static void mergeSort(int[] input, int start, int end) {
		
		if(start>=end)
			return;
		int mid=(start+end)/2;
		
		mergeSort(input, start, mid);
		mergeSort(input, mid+1, end);

		merge(input,start,end);
		
		
	}
	
	private static void merge(int[] input, int start, int end) {
		int mid=(start+end)/2;
		int ans[]= new int[end-start+1];
		int i=start;
		int j=mid+1;
		int k=0;
		
		while(i<=mid && j<=end) {
			if(input[i]<input[j]) {
				ans[k]=input[i];
				k++;
				i++;
			}
			else {
				ans[k]=input[j];
				k++;
				j++;
			}
		}
		
		if(i<=mid) {
			ans[k]=input[i];
			k++;
			i++;
		}
		if(j<=end) {
			ans[k]=input[j];
			k++;
			j++;
		}
		
		for (int l = 0; l < ans.length; l++)
			input[start+l]=ans[l];
		
		
	}

	public static void main(String[] args) {
         int input[]= {2 ,6 ,8 ,5 ,4 ,3};
         mergeSort(input,0,input.length-1);
         System.out.println(Arrays.toString(input));
         
      }

}
