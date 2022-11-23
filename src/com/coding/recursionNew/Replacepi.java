package com.coding.recursionNew;

public class Replacepi {

	public static String replace(String input){
		
		if(input.length()<=1)
			return input;
		
		if(input.charAt(0)=='p' && input.charAt(1)=='i' && input.length()>=2) {
			return "3.14"+ replace(input.substring(2,input.length()));
		}
		
		return  input.charAt(0)+replace(input.substring(1,input.length()));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(replace("safsapisdfspi"));
	}

}
