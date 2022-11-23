package com.coding.recursion;

public class NumberofDigits {
	static int count=1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=156565;
		System.out.println(count(n));

	}

	private static int count(int n) {
		// TODO Auto-generated method stub
		if(n == 0){
			return 0;
		}
		int smallAns = count(n / 10);
		return smallAns + 1;
	}

}
