package com.coding.recursion;

public class PrintNumbers {
	static int count=1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		print(n);

	}

	private static void print(int n) {
		// TODO Auto-generated method stub
		if(n == 0)
			return;
		
		System.out.print(count++ +" ");
		print(n - 1);
	}

}
