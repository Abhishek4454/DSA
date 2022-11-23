package com.coding.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoveDuplicatesInArray {
    
	
	public static ArrayList<Integer> removeDuplicates(int arr[]){
		HashMap<Integer, Boolean> seen= new HashMap<Integer, Boolean>();
		ArrayList<Integer> output= new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(seen.containsKey(arr[i]))
				continue;
			seen.put(arr[i], true);
			output.add(arr[i]);
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int arr[]= {1,2,3,4,5,5,4,3,3,2,4,1};
       System.out.println(removeDuplicates(arr));
	}

}
