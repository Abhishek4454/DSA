package com.coding.recursionNew;

public class TowerofHanoiXXX {
	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination) {
		// Write your code here
        
		if(disks==1) {
			System.out.println(source +" "+destination);
			return;
		}
		
		towerOfHanoi(disks-1, source,destination, auxiliary );
		System.out.println(source +" "+destination);
		towerOfHanoi(disks-1,  auxiliary,source, destination);
        

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		towerOfHanoi(3,'A','B','C');
	}

}
