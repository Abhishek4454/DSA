package com.coding.recursionNew;

public class PrintNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        print(6);
	}

	public static void print(int n){
		if(n==0)
			return;
		
		print(n-1);
		
		System.out.print(n+" ");
		
		
        
    } 
}
