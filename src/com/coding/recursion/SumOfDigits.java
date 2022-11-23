package com.coding.recursion;

public class SumOfDigits {
	public static int sumOfDigits(int input){
		int sum=0;
	
		if(input<=0)
			return 0;
		
	
		if(input%10 >= 0)
			sum=input%10+sumOfDigits(input/10);
		
		return sum;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(sumOfDigits(165));
	}

}
