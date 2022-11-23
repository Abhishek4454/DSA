package com.coding.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class PairSumto0XXX {

	public static void main(String[] args) {
		
		//int arr[]= {2, 1 ,-2 ,2 ,3};
		int arr1[]= { 95 ,-97, -387, -435, -5 ,-70, 897, 127, 23 ,284};
		// System.out.println(pairSum(arr, arr.length));
		System.out.println(largestSubArray(arr1));

	}
	
	public static int largestSubArray(int arr[]){
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		int mlen=0;
		
		int i=-1;
		int sum=0;
		hm.put(sum, i);
		
		while(i<arr.length-1) {
			i++;
			sum+=arr[i];
			
			if(hm.containsKey(sum)==false) {
				hm.put(sum,i);
			}else {
				int length=i-hm.get(sum);
				if(length>mlen)
					mlen=length;
			}
		}
		return mlen;
	}
	
	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		// Write your code here
		
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		int i=-1;
		int sum=0;
		hm.put(sum, i);
		int mlen=0;
		
		while(i<arr.length) {
			i++;
			sum+=arr[i];
			hm.put(sum, i);
			
			if(hm.containsKey(sum)==false) {
				hm.put(sum,i);
			}else {
				int length=i-hm.get(sum);
				if(length>mlen)
					mlen=length;
			}
		}
		return mlen;
	
	}

     public static int pairSum(int[] input, int size) {
		
		int ans=0;
		if (size == 0)
			return 0;
		HashMap<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < size; i++) {
			if (h.containsKey(-input[i]) && h.get(-input[i]) != 0) {
				int count = h.get(-input[i]);

				while (count != 0) {
					ans++;
					count--;
				}
				if (h.containsKey(input[i]))
					h.put(input[i], h.get(input[i]) + 1);
				else
					h.put(input[i], 1);
			} else {
				if (h.containsKey(input[i])) {
					h.put(input[i], h.get(input[i]) + 1);
				} else {
					h.put(input[i], 1);
				}
			}

		}
         return ans;
}
}
