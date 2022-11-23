package com.coding.GenericTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class PrintAtK {

	private static void printAtK(TreeNode<Integer> root,int k){
		
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		
		for(int i=0;i<root.next.size();i++)
			printAtK(root.next.get(i), k-1);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeUse tree=new TreeUse();
       TreeNode<Integer> root= takeInputLevelWise();
       // printLevelWise(root);
       // printAtK(root,2);
        preorder(root);
	}
	
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
		
		if (root.data == x)
			return true;
		boolean ans = false;
		for (int i = 0; i < root.next.size(); i++) {
			boolean smallAns = checkIfContainsX(root.next.get(i), x);
			if (smallAns != ans && smallAns == true)
				ans = smallAns;
		}

		return ans;
	}
//	Node having sum of children and node is max
//	Send Feedback
//	Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
//	Input format :
//
//	Line 1 : Elements in level order form separated by space (as per done in class). Order is -
//
//	Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
//
//	Output format : Node with maximum sum.
//
//	Sample Input 1 :
//	5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
//	Sample Output 1 :
//	1
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		
		if(root==null)
			return root;
		int sum=root.data;
		TreeNode<Integer> ans=root;
		for(int i=0;i<root.next.size();i++) {
			sum+=root.next.get(i).data;
		}
		
		for(int i=0;i<root.next.size();i++) {
			TreeNode<Integer> childMax=maxSumNode(root.next.get(i));
			
			int smallSum=childMax.data;
			
			for(int j=0;j<childMax.next.size();j++)
				smallSum+=childMax.next.get(j).data;
			
			if(smallSum>sum) {
				sum=smallSum;
				ans=childMax;
			}
			
		}
		
		return ans;
	}

	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

		if(root1.data!=root2.data)
			return false;
		
		if(root1.next.size()!=root2.next.size())
			return false;
		
		boolean identical=true;
		
		for(int i=0;i<root1.next.size();i++) {
		   return checkIdentical(root1.next.get(i), root2.next.get(i));
		   
		}
		
		return identical;
	}

	private static void preorder(TreeNode<Integer> root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		for(int i=0;i<root.next.size();i++)
			preorder(root.next.get(i));
		
		
	}
	
	private static void postOrder(TreeNode<Integer> root) {
		if(root==null)
			return;
		
		for(int i=0;i<root.next.size();i++) {
			preorder(root.next.get(i));
			
		}
		System.out.print(root.data+" ");
		
	}

	
	
	
	public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
        Queue<TreeNode<Integer>> mq= new LinkedList<TreeNode<Integer>>();
		mq.add(root);
		Queue<TreeNode<Integer>> cq= new LinkedList<TreeNode<Integer>>();

		while(mq.size()>0) {
			root=mq.poll();
			System.out.print(root.data+" : ");
			
			for(int i=0;i<root.next.size();i++) 
				cq.add(root.next.get(i));
			
			if(mq.size()==0) {
				mq=cq;
				cq=new LinkedList<TreeNode<Integer>>();
				System.out.println();
			}
		}
	}
	
	
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {

		if (root == null)
			return root;

		TreeNode<Integer> ans = null;
		if (root.data > n)
			ans = root;

		for (int i = 0; i < root.next.size(); i++) {

			TreeNode<Integer> temp = findNextLargerNode(root.next.get(i), n);

			if (temp != null) {
				if (ans == null || ans.data > temp.data)
					ans = temp;
			}

		}
		return ans;
	}
	

	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner sc= new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		System.out.println("Enter the root element : ");
		int rootData = sc.nextInt();
		
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			currentNode = pendingNodes.poll();
			System.out.println("Number of child for "+currentNode.data);
			int numChild = sc.nextInt();
			for(int i = 0 ; i < numChild; i++){
				System.out.println("Element for child at "+(i+1)+" index of "+currentNode.data);
				int currentChild = sc.nextInt();
				TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
				pendingNodes.add(childNode);
				currentNode.next.add(childNode);
			}
		}
		return root;
	}
}
