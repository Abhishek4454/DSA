package com.coding.recursionNew;

public class MultiplicationRecursive {
	public static int multiplyTwoIntegers(int m, int n){
		if(n==1)
			return m;
		
		return m+multiplyTwoIntegers(m, n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(multiplyTwoIntegers(3, 4));
	}

}
