package com.coding.recursionNew;

import java.util.Arrays;

public class ReturnAllCodesXXX {

	public static String[] getCode(String input) {
		if (input.length() == 0) {
			String ans[] = { "" };
			return ans;
		}
		String smallans[] = getCode(input.substring(1));

		int an = input.charAt(0) - '0';//this will result integer value for first character
		char firstchar = (char) ('a' + an - 1);//than changes for corresponding integer

		for (int i = 0; i < smallans.length; i++) {
			smallans[i] = firstchar + smallans[i];
		}

		String smallans1[] = new String[0];
		if (input.length() >= 2) {
			int ch1 = input.charAt(0) - '0';
			int ch2 = input.charAt(1) - '0';
			int an3 = (ch1 * 10) + ch2;

			if (an3 >= 10 && an3 <= 26) {
				char firsttwochar = (char) ('a' + an3 - 1);
				smallans1 = getCode(input.substring(2));
				for (int i = 0; i < smallans1.length; i++) {
					smallans1[i] = firsttwochar + smallans1[i];
				}
			}
		}
		String output[] = new String[smallans.length + smallans1.length];
		int k = 0;
		for (int i = 0; i < smallans.length; i++) {
			output[k] = smallans[i];
			k++;
		}
		for (int i = 0; i < smallans1.length; i++) {
			output[k] = smallans1[i];
			k++;
		}
		return output;
	}

	 
    public static  void printAllPossibleCodes(String input){
    	printAllPossibleCodes(input,"");
    }

	private static void printAllPossibleCodes(String input, String rsf) {//input=123
		//if input is empty just retirn the result(rsf)
		if(input.length()==0) {
			System.out.println(rsf);
			return;
		//if input length=1	
		}else if(input.length()==1) {
			char ch=input.charAt(0);//take the first char
			if(ch=='0') {//if 0 return nothing as no need any result
				return;
			}else {
				int chv=ch-'0';//for char 1-9
				char code=(char) ('a'+chv-1);//ASCII of '0'=48 and '1'=49 and so on
				System.out.println(rsf+code);//return the result after appending the values here
			}
		}else {//Else the value is >1
			char ch=input.charAt(0);//Processing for the first character
			String roq=input.substring(1);
			if(ch=='0') {
				return;
			}else {
				int chv=ch-'0';
				char code=(char) ('a'+chv-1);
				printAllPossibleCodes(roq,rsf+code);//we just need to add in the result through recursion
			}
			
			String ch12=input.substring(0,2);//Also we will process for the 10<=ch<=26
			String roq12=input.substring(2);
			int ch12v=Integer.parseInt(ch12);
			if(ch12v<=26) {
				char code=(char) ('a'+ch12v-1);
				printAllPossibleCodes(roq12, rsf+code);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllPossibleCodes("1123");
		System.out.println(Arrays.toString(getCode("1123")));
	}

}
