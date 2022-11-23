package com.coding.recursionNew;

public class RemoveDuplicatesRecursively {
	public static String removeConsecutiveDuplicates(String s) {
		if(s.length()<=1)
			return s;
		
		if(s.charAt(0)!=s.charAt(1))
			return s.charAt(0)+removeConsecutiveDuplicates(s.substring(1,s.length()));
		
		return removeConsecutiveDuplicates(s.substring(1,s.length()));
		
		
//		if(s.length()<=1)
//			return s;
//		
//		if(s.charAt(0)!=s.charAt(1))
//			 return s.charAt(0)+ removeConsecutiveDuplicates(s.substring(1));
//		
//		return removeConsecutiveDuplicates(s.substring(1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(removeConsecutiveDuplicates("aaabbbbccccccc"));
	}

}
