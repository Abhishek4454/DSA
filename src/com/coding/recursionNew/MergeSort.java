package com.coding.recursionNew;

import java.util.Arrays;

public class MergeSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[]= {3,12,11,25,1,2,24};
	   System.out.println(Arrays.toString(input));
       mergeSort(input);
       System.out.println(Arrays.toString(input));
	}

	
	private static void mergeSort(int[] input) {
		
		if(input.length<=1)
			return;
		
		int mid=input.length/2;//3
		int part1[]=new int[mid];//[3,12,11]  
		int part2[]=new int[input.length-mid];//[25,1,2,24,3]
		
		for(int i=0;i<mid;i++) 
			part1[i]=input[i];
		int k=0;
		for(int i=mid;i<input.length;i++) 
			{
			part2[k]=input[i];
			k++;
			}
		
		mergeSort(part1);
		mergeSort(part2);
		merge(part1,part2,input);
		
	}

	private static void merge(int[] part1,int[] part2,int result[] ) {
		// TODO Auto-generated method stub
		//int result[]= new int[input.length]; 
		int i=0,j=0,k=0;;
		while(i<part1.length && j<part2.length) {
			
			if(part1[i]<part2[j])
			{
				result[k]=part1[i];
				
				k++;
				i++;
			}
			
			else 
			{
				result[k]=part2[j];
				
				k++;
				j++;
			}
			
		}
		
		while(i<part1.length)
		{
			result[k]=part1[i];
			i++;
			k++;
		}
		
		while(j<part2.length)
		{
			result[k]=part2[j];
			j++;
			k++;
		}
		
	}

}
