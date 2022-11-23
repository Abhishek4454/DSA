package com.coding.recursionNew;

public class FibonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(getfibonacciNumber(3));
	}

	private static int getfibonacciNumber(int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			return 0;
		}
		return n+ getfibonacciNumber(n-1);
	}

}
