package com.coding.recursionNew;

public class NumberofDigits {
	public static int count(int n){
     
		if(n==0) {
			return 0;
		}
		
		return 1+count(n/10);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(count(156));
	}

}
