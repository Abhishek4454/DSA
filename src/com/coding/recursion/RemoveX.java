package com.coding.recursion;

public class RemoveX {
	public static String removeX(String input){
		
		if(input.length()==0)
			return "";
		
		if(input.charAt(0)=='x')
			return removeX(input.substring(1,input.length()));
		
		return input.charAt(0)+removeX(input.substring(1,input.length()));

	}
	public static void main(String[] args) {
		System.out.println(removeX("abxcxd"));

	}

}
