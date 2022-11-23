package com.coding.recursionNew;

public class StringtoInteger {

	public static int convertStringToInt(String input) {
		if (input.length() == 0)
			return 0;

			return (int) (Character.getNumericValue(input.charAt(0)) * Math.pow(10, input.length()-1))
					+ convertStringToInt(input.substring(1));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(convertStringToInt("12345"));
	}

}
