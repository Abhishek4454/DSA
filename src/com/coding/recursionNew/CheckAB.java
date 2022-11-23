package com.coding.recursionNew;



//Check AB
//Send Feedback
//Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
//a. The string begins with an 'a'
//b. Each 'a' is followed by nothing or an 'a' or "bb"
//c. Each "bb" is followed by nothing or an 'a'
//If all the rules are followed by the given string, return true otherwise return false.
//Input format :
//String S
//Output format :
//'true' or 'false'
//Constraints :
//1 <= |S| <= 1000
//where |S| represents length of string S.
//Sample Input 1 :
//abb
//Sample Output 1 :
//true
//Sample Input 2 :
//abababa
//Sample Output 2 :
//false
//Explanation for Sample Input 2
//In the above example, a is not followed by either "a" or "bb", instead it's followed by "b" which results in false to be returned.
//
public class CheckAB {

	public static boolean checkAB(String str){
		//if string is empty that means we reached end of the string and the return is true which is a base case
		if(str.isEmpty())
			return true;
		
		//check starts with checking first character as 'a'
		if(str.charAt(0)=='a') {
			//1st possiblity:Each 'a' is followed by   "bb"
			if(str.length()>2 && str.substring(1,3).equals("bb"))
				return checkAB(str.substring(3));
			else
				return checkAB(str.substring(1));//Each 'a' is followed by nothing
		}
		//if above not true than return false
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(checkAB("abb"));

	}

}
