package com.coding.recursionNew;

import java.util.Arrays;

public class KeyPadCombinationsXXX {
	
	public static String[] returnKeypad(int input) {
		
		if(input==0) {
			String str[]= {""};
			return str;
		}
		
		int lastDigit=input%10;
		int smallNumber=input/10;
		String smallAns[]=  returnKeypad(smallNumber);
		char[] options= optionHelper(lastDigit);
		String finalAns[]=new String[smallAns.length*options.length];
		int k=0;
		for (int i = 0; i < smallAns.length; i++) {
			for (int j = 0; j < options.length; j++) {
				finalAns[k++]=smallAns[i]+options[j];
			}
		}
		return finalAns;
	}

	
	public static void printKeypad(int n) {
		
		printKeypad(n,"");
	}
	
	private static void printKeypad(int n, String output) {
		// TODO Auto-generated method stub
		
		if(n==0){
			System.out.println(output);
			return ;
		}
		
		int lastDigit=n%10;
		char option[]=optionHelper(lastDigit);
		
		for (int i = 0; i < option.length; i++) {
			printKeypad(n/10,option[i]+output);
		}
		
	}


	private static char[] optionHelper(int lastDigit) {
		if(lastDigit<0 || lastDigit>10){
            System.exit(0);
        }
      switch (lastDigit) {
		case 2:
			char options1[] = { 'a', 'b', 'c' };
			return options1;
		case 3:
			char options2[] = { 'd', 'e', 'f' };
			return options2;
		case 4:
			char options3[] = { 'g', 'h', 'i' };
			return options3;
		case 5:
			char options4[] = { 'j', 'k', 'l' };
			return options4;
		case 6:
			char options5[] = { 'm', 'n', '0' };
			return options5;
        case 7:
			char options6[] = { 'p', 'q', 'r','s' };
			return options6;
		case 8:
			char options7[] = {  't', 'u','v' };
			return options7;
		case 9:
			char options8[] = { 'w', 'x','y','z' };
			return options8;
              
              
	  default:
		   char options[]= {'\0'};
		   return options;
	}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(Arrays.toString(returnKeypad(456)));
       printKeypad(23);
	}

}
