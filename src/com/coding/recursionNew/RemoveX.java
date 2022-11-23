package com.coding.recursionNew;

public class RemoveX {

	public static String removeX(String input){
		if(input.length()<=0)
			return input;
		
		if(input.charAt(0)=='x')
			return removeX(input.substring(1,input.length()));
		else
		    return input.charAt(0) + removeX(input.substring(1,input.length()));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(removeX("xaxb"));
	}

}
