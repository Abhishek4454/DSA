package com.coding.recursion;

public class RemoveDuplicatesRecursively {
	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
		if(s.length()<=1)
			return s;
		
		if(s.charAt(0)!=s.charAt(1))
			 return s.charAt(0)+ removeConsecutiveDuplicates(s.substring(1));
		
		return removeConsecutiveDuplicates(s.substring(1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(removeConsecutiveDuplicates("xxxyyyzwwzzz"));
	}

}
