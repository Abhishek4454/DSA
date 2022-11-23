package com.coding.recursionNew;

public class CheckPalindrome {

	public static boolean isStringPalindromePrevious(String input) {
		return isStringPalindrome(input,0,input.length()-1);
	}
	
	private static boolean isStringPalindrome(String input, int startIndex, int lastIndex) {
		 // If there is only one character
        if (startIndex == lastIndex)
            return true;
 
        // If first and last
        // characters do not match
        if ((input.charAt(startIndex)) != (input.charAt(lastIndex)))
            return false;
 
        // If there are more than
        // two characters, check if
        // middle substring is also
        // palindrome or not.
        if (startIndex < lastIndex + 1)
            return isStringPalindrome(input,startIndex+ 1,lastIndex-1);
 
        return true;
	
	}
	
	public static boolean isStringPalindrome(String input) {
		
		if(input.length()<=1)
			return true;
		
		if(input.charAt(0)==input.charAt(input.length()-1))
			return isStringPalindrome(input.substring(1, input.length()-1));
		else
			return false;
	}

	public static void main(String[] args) {
		
      System.out.println(isStringPalindrome("dracecard"));
	}

}
