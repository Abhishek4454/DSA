package com.coding.GenericTree;

public class SumNodes {

	private static int countNumNodes(TreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		int sum=root.data;
		for(int i=0;i<root.next.size();i++)
			sum += countNumNodes(root.next.get(i));
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUse tree=new TreeUse();
        TreeNode<Integer> root= tree.takeInputLevelWise();
        System.out.println(countNumNodes(root));
	}

}
