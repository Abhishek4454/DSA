package com.coding.recursion;

public class CalculatePower {

	public static void main(String[] args) {
		int x=3;
		int n=4;
       int result=getResult(3,4);
       System.out.println(result);
	}

	private static int getResult(int x, int n) {
		
		if(n==0) {
			return 1;
		}
		
		int result=x*getResult(x, n-1);
		
		return result;
	}

}
