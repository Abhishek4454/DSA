package com.coding.recursion;

public class Multiplication {
	public static int multiplyTwoIntegers(int m, int n){
		// Write your code here
        if(n<1)
            return 0;
	    return m+multiplyTwoIntegers(m, n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(multiplyTwoIntegers(4, 3));
	}

}
