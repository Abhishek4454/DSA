package com.coding.HashMap;

import java.util.HashMap;

public class MaximumFrequencyNumber {

	public static int maxFrequencyNumber(int[] arr) {
       
		HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
		int count=1;
		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(arr[i]))
				hm.put(arr[i], hm.get(arr[i]) + 1);
			else
				hm.put(arr[i], count);
		}
		
		 int max = 0, ans = Integer.MIN_VALUE;
         for(int i=0; i<arr.length; i++) {
           if(hm.get(arr[i]) > max) {
             max = hm.get(arr[i]);
             ans = arr[i];
           }
         }

         return ans;
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
