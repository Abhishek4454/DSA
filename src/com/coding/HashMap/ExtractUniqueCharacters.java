package com.coding.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExtractUniqueCharacters {
	
	public static String uniqueChar(String str){
		
		HashMap<Character, Boolean> freq=new HashMap<Character, Boolean>();
		String result="";
		for(int i=0;i<str.length();i++) {
			if(freq.containsKey(str.charAt(i))) {
				continue;
			}else {
				result+=str.charAt(i);
				freq.put(str.charAt(i), true);
			}
		}
        return result;
	}
	
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
       String str="ababacd";
       System.out.println(uniqueChar(str));
	}

}
