package com.coding.recursionNew;

public class PairStringXXX {
	public static String addStars(String s) {
		if(s.length()<2)
			return s;
		
		String smallAns=addStars(s.substring(1));
		if(smallAns.charAt(0)==s.charAt(0))
			return s.charAt(0)+"*"+smallAns;
		else
			return s.charAt(0)+smallAns;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(addStars("gggggiuoiuuoiull"));
	}

}
