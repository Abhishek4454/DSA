package com.coding.GenericTree;


public class HeightOfTree {

	private static int heightTree(TreeNode<Integer> root){
		// TODO Auto-generated method stub
//		if(root==null)
//			return 0;
//		
//		int height=0;
//		
//		for (int i = 0; i < root.next.size(); i++) {
//			int childHeight=heightTree(root.next.get(i));
//			Math.max(childHeight, height);
//		}
//		
//		return height+1;
		
		if(root==null)
			return 0;
		
		int height=0;
		
		for (int i = 0; i < root.next.size(); i++) {
			int childHeight=heightTree(root.next.get(i));
			 height= Math.max(childHeight,height);
		}
		
		return height+1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUse tree=new TreeUse();
        TreeNode<Integer> root= tree.takeInputLevelWise();
        System.out.println(heightTree(root));
	}

}
