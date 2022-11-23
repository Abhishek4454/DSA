package com.coding.HashMap;

import java.util.HashMap;

public class PairsWithDifferenceKXXX {

	public static int getPairsWithDifferenceK(int input[], int k) {
		 HashMap<Integer,Integer> map=new HashMap<>();
       int ans=0;
       for(int i=0;i<input.length;i++){
           if(!map.containsKey(input[i])){

               map.put(input[i],1);

           }else{
               int oldfreq=map.get(input[i]);
               map.put(input[i],oldfreq+1);

           }
       }
       if(k==0){
           for(int i=0;i<input.length;i++){
               int freq=map.get(input[i]);
               if(freq>1){
                   for(int j=0;j<(freq*(freq-1))/2;j++){
                      // System.out.println(input[i]+" "+input[i]);
                      ans++;
                   }

               }
               map.put(input[i],0);
           }
       }
       else{
           for(int i=0;i<input.length;i++){
               if(map.containsKey(input[i]+k)){
                   int freq1=map.get(input[i]);
                   int freq2=map.get(input[i]+k);
                   for(int j=0;j<freq1*freq2;j++){
                      // System.out.print(input[i]+" ");
                      // System.out.println(input[i]+k);
                       ans++;

                   }

               }
               if(map.containsKey(input[i]-k)){
                   int freq1=map.get(input[i]);
                   int freq2=map.get(input[i]-k);
                   for(int j=0;j<freq1*freq2;j++){
                       // System.out.print(input[i]-k+" ");
                       // System.out.println(input[i]);
                       ans++;


                   }
               }
               map.put(input[i],0);

           } 
       }  
       return ans;
	}
	public static void main(String[] args) {
		

	}

}
