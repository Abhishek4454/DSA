package com.coding.recursionNew;

public class CalculatePower {
	public static int power(int x, int n) {
		int ans=0;
		if(n==0) {
			return 1;
		}
		
		ans=x*power(x, n-1);
		
		
		return ans;
		
		
	}
	public static void main(String[] args) {
		
		System.out.println(power(3, 4));

	}

}
