package com.coding.recursion;

public class PairStar {
	
	public static String addStars(String s) {
       
//		if(s.length()<=0)
//			return s;
//		
//		if(s.length()>1  &&  s.charAt(0)==s.charAt(1))
//			return s.charAt(0)+"*"+s.charAt(1)+addStars(s.substring(2, s.length()));
//		
//		return s.charAt(0)+addStars(s.substring(1, s.length()));
		 if(s.length()==1)
	            return s;
	        String smallans=addStars(s.substring(1));
	        if(s.charAt(0)==smallans.charAt(0))
	            return s.charAt(0)+"*"+smallans;
	        else
	            return s.charAt(0)+smallans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(addStars("aaaa"));
	}

}
