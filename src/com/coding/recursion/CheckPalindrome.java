package com.coding.recursion;

public class CheckPalindrome {
	public static boolean isStringPalindrome(String input) {
		return isStringPalindrome(input,0,input.length()-1);
	}
	
	private static boolean isStringPalindrome(String input, int startIndex, int lastIndex) {
		
		if(startIndex==lastIndex)
			return true;

		if(input.charAt(startIndex)!=input.charAt(lastIndex))
			return false;
		if(startIndex<lastIndex+1)
			return isStringPalindrome(input,startIndex+1,lastIndex-1);
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(isStringPalindrome("ninja"));
	}

}
