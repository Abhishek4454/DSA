package com.coding.GenericTree;

import com.coding.LinkedList.Node;

public class LargestNode {

	private static int largestNodes(TreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		
		int largest=root.data;
		for(int i=0;i<root.next.size();i++) {
			int ans=largestNodes(root.next.get(i));
			if(ans>largest)
				largest=ans;
		}
			
		
		return largest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeUse tree=new TreeUse();
        TreeNode<Integer> root= tree.takeInputLevelWise();
        System.out.println(largestNodes(root));
	}

}
