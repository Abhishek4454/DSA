package com.coding.recursionNew;

import java.util.Arrays;

public class ReturnSubsequencesXXX {

	public static String[] returnSubsequences(String str) {
		
		if(str.length()==0)
		{
			String abc[]= {""};
			return abc;
		}
		
		String smallAns[]=returnSubsequences(str.substring(1));
		
		String finalAns[]=new String[smallAns.length*2];
		
		int k=0;
		for (int i = 0; i < smallAns.length; i++) {
			finalAns[k++]=smallAns[i];
		}
		
		for (int i = 0; i < smallAns.length; i++) {
			finalAns[k++]=str.charAt(0)+ smallAns[i];
		}
		
		return finalAns;
	}
	
	public static void printSubsequence(String input){
		
		printSubsequence(input,"");
	}
	private static void printSubsequence(String input, String output) {
		if(input.length()==0) {
			System.out.print(output+" ");
			return;
		}
		
		printSubsequence(input.substring(1),output);
		
		printSubsequence(input.substring(1),output+input.charAt(0));

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println(Arrays.toString(returnSubsequences("xyz")));
         
         printSubsequence("xyz");
	}

}
