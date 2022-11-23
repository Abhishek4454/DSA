package com.coding.recursionNew;

public class DoesScontainT {
	public static boolean checkSequence(String s, String t) {
		if(t.length()==0)
			return true;
		if(s.length()==0)
			return false;
		
		if(s.charAt(0)==t.charAt(0)) {
			return checkSequence(s.substring(1), t.substring(1));
		}else {
			return checkSequence(s.substring(1), t);
		}
			
		
//		 if(s.charAt(0) == t.charAt(0)){
//	            s = s.substring(1);
//	            t = t.substring(1);
//	        }else{
//	            s = s.substring(1);
//	        }
//	        
//	        boolean ans = checkSequence(s,t);
//
//		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s="abchjsgsuohhdhyrikkknddg";
        String t="coding";
        System.out.println(checkSequence(s, t));
        
	}

}
