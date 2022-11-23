package com.coding.recursionNew;

public class Sumofdigits {

	
	public static int sumOfDigits(int input){
		
		if(input<=0)
			return 0;
		
        return input%10 + sumOfDigits(input/10);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(sumOfDigits(12345));
	}

}
