package com.coding.recursionNew;

public class ReplaceCharacterRecursively {
	public static String replaceCharacter(String input, char a, char x) {
		
		if(input.isEmpty())
			return input;
		
		
			//input=input.replace(a, x);
		
		if(input.charAt(0)==a)
			return x+"" + replaceCharacter(input.substring(1),a,x);
		
		return input.charAt(0)+ replaceCharacter(input.substring(1),a,x);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(replaceCharacter("abacd",'a','x'));
	}

}
