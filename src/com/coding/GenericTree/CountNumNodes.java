package com.coding.GenericTree;

public class CountNumNodes {

	private static int countNumNodes(TreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		int count=1;
		for(int i=0;i<root.next.size();i++)
			count +=countNumNodes(root.next.get(i));
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUse tree=new TreeUse();
        TreeNode<Integer> root= tree.takeInputLevelWise();
        System.out.println(countNumNodes(root));
	}

}
