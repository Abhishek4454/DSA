package com.coding.recursion;

public class ReplaceCharacterRecursively {
	public static String replaceCharacter(String input, char c1, char c2) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		if(input.isEmpty())
			return input;
		String ans="";
		if(input.charAt(0)!=c1)
			ans=ans+input.charAt(0);
		else
			ans=ans+c2;
		
		String smallAns=replaceCharacter(input.substring(1), c1, c2);
		
		return ans+smallAns;
			
			

	}
	public static void main(String[] args) {
		
		System.out.println(replaceCharacter("abcadsash", 'a', 'x'));

	}

}
