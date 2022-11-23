package com.coding.HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayIntersection {

	public static void main(String[] args) {
		
		
		int arr1[]= {2,3,4,2,5,6,2,3,4};
		int arr2[]= {3,5,7,8,2,2,4,3,7,5};
		
		 System.out.println(Arrays.toString(arrayIntersection(arr1,arr2)));

	}

	private static int[] arrayIntersection(int[] arr1, int[] arr2) {
        
		HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr1.length; i++) {
			if(hm.containsKey(arr1[i])) {
				int value=hm.get(arr1[i]);
				hm.put(arr1[i], value+1);
			}
			else
				hm.put(arr1[i], 1);
		}
		
		int result[]=new int[arr2.length];
		int k=0;
		
		for (int i = 0; i < arr2.length; i++) {
			
			if(hm.containsKey(arr2[i])) {
				int freq=hm.get(arr2[i]);
				if(freq>0) {
				result[k++]=arr2[i];
				hm.put(arr2[i], freq-1);
				}
			}
				
		}
		
		return result;
	}

}
