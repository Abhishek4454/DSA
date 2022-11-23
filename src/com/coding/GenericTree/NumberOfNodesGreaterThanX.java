package com.coding.GenericTree;


public class NumberOfNodesGreaterThanX {

	private static int numNodeGreater(TreeNode<Integer> root,int x){
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		int count=0;
		
		if(root.data>x)
			count++;
		
		for (int i = 0; i < root.next.size(); i++) {
			count+=numNodeGreater(root.next.get(i), x);
		}
		
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUse tree=new TreeUse();
        TreeNode<Integer> root= tree.takeInputLevelWise();
        System.out.println(numNodeGreater(root,35));
	}

}
