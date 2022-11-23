package com.coding.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray {

	public static void main(String[] args) {
		int arr[]= {2,4,1,9,6,8};
		//We need to sort k sorted array
		System.out.println(Arrays.toString(kSortedArray(arr,3)));

	}

	private static int[] kSortedArray(int[] arr,int k) {
		
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
		int i=0;
		for ( ;i < k; i++) {//insert first k element 
			pq.add(arr[i]);
		}
		
		for(;i<arr.length;i++) {
			arr[i-k]=pq.remove();//Remove the element to find the minimum which is inserted at begining
			pq.add(arr[i]);//keep adding the element till arr.lenght
		}
		
		for(int j=arr.length-k;j<arr.length;j++) {
			arr[j]=pq.remove();//process the remaining element i.e arr.length-k
		}
		
		return arr;
		
	}

}
