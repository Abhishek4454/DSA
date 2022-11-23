package com.coding.HashMap;

import java.util.ArrayList;
import java.util.HashMap;


public class LongestConsecutiveSequence {

	//As per sumeet malik
	public static ArrayList<Integer> longestConsecutiveIncreasingSequenceBySumeet(int[] arr) {
		HashMap<Integer, Boolean> hm= new HashMap<Integer, Boolean>();
		for(int data:arr)
			hm.put(data, true);
		
		for(int data:arr) {
			if(hm.containsKey(data-1))
				hm.put(data, false);
		}
		
		int maxStartPoint=0;
		int maxLength=0;
		for(int data:arr) {
			if(hm.get(data)==true) {
				int tempStartingpoint=data;
				int tempLength=1;
				while(hm.containsKey(tempStartingpoint+tempLength)) {
					tempLength++;
				}
				if(tempLength>maxLength) {
					maxStartPoint=tempStartingpoint;
					maxLength=tempLength;
				}
					
			}
		}
		ArrayList<Integer> ouput=new ArrayList<Integer>();
		ouput.add(maxStartPoint);
		ouput.add(maxStartPoint+maxLength-1);
		
		return ouput;
		
		
	}

	//As per CN soln
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], 1);
		}

		int overallcount = 0, maxStart = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(arr[i] - 1)) {
				int currentcount = 1;
				int currentstart = arr[i];

				while (map.containsKey(currentstart + 1)) {
					currentcount++;
					currentstart = currentstart + 1;
				}
				if (currentcount > overallcount) {
					overallcount = currentcount;
					maxStart = arr[i];
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(maxStart);
		ans.add(maxStart + overallcount - 1);

		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2 ,12 ,9 ,16 ,10 ,5 ,3 ,20 ,25 ,11 ,1 ,8 ,6 };
        System.out.println(longestConsecutiveIncreasingSequenceBySumeet(arr));
	}

}
