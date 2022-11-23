package com.coding.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeUse {

	public static void main(String[] args) {
       
	}
	
//	LCA of BST
//	Send Feedback
//	Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.
//	LCA
//	LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 
//	Example:
//	In this example, the green coloured node is the LCA to A and B.
//	Alt Text
//
//	Note:
//	It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a direct connection from Y, then Y is the lowest common ancestor.
//	Example:
//	Alt Text
//
//	Note:
//	1. If out of 2 nodes only one node is present, return that node. 
//	2. If both are not present, return -1.
//	3. all the node data will be unique.
//	Input format:
//	The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
//	The following line of input contains two integers, denoting the value of data of two nodes of given BST.
//	Output Format:
//	The first and only line of output contains the data associated with the lowest common ancestor node.
//	Constraints:
//	Time Limit: 1 second
//	Sample Input 1:
//	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//	2 10
//	Sample Output 1:
//	8
//	Sample Input 2:
//	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//	2 6
//	Sample Output 2:
//	5
//	Sample Input 3:
//	8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
//	12 78
//	Sample Output 3:
//	-1
	
	public static int getLCABetter(BinaryTreeNode<Integer> root, int a, int b) {
		if(root.data>a && root.data>b)
			return getLCABetter(root.rightNode, a, b);
		if(root.data<a && root.data<b)
			return getLCABetter(root.leftNode, a, b);
		else
			return root.data;
	}
	
	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		
		 if(root==null)
           return -1;
       int c=-1;
       if(root.data==a || root.data==b)
           return root.data;
     
      else if(a<root.data && b>root.data || a>root.data && b<root.data)
       {
            c=getLCA(root.leftNode,a,b);
           int d=getLCA(root.rightNode,a,b);
           if(c==-1 && d==-1)
               return -1;
           else if(c==-1 && d!=-1)
               return  d;
           else if(c!=-1 && d==-1)
               return c;
           else
               return root.data;
       }
       
        else if(a<root.data &&b<root.data)
       {
            c=getLCA(root.leftNode,a,b);
       }
      else if(a>root.data &&b>root.data)
       {
            c=getLCA(root.rightNode,a,b);
       }
   
       if(c!=-1)
           return c;
        else
           return -1;

	}
	public static ArrayList<Integer> getRootToNode(BinaryTreeNode<Integer> root,int k){
		if(root==null)
			return null;
		
		if(root.data == k) {
			ArrayList<Integer> output= new ArrayList<Integer>();
			output.add(root.data);
			return output;
		}
		
		if(k>root.data) {
			ArrayList<Integer> rightOutput=getRootToNode(root.rightNode, k);
			if(rightOutput!=null) {
				rightOutput.add(root.data);
				return rightOutput;
			}
		}
		
		if(k<root.data) {
			ArrayList<Integer> leftOutput=getRootToNode(root.leftNode, k);
			if(leftOutput!=null) {
				leftOutput.add(root.data);
				return leftOutput;
			}
		}
		
		return null;
			
	}
	
	public static Node<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {

		return constructLinkedListhelper(root).first;
		
	}
	
	public static Pair<Node<Integer>, Node<Integer>> constructLinkedListhelper(BinaryTreeNode<Integer> root) {
		if(root==null) {
			Pair<Node<Integer>, Node<Integer>> output=new Pair<Node<Integer>, Node<Integer>>();
			output.first=null;//first is head
			output.second=null;//second is tail
			return output;
		}
		
		Pair<Node<Integer>, Node<Integer>> leftOutput=constructLinkedListhelper(root.leftNode);
		Node<Integer> newNode=new Node<Integer>(root.data);
		Pair<Node<Integer>, Node<Integer>> rightOutput=constructLinkedListhelper(root.rightNode);
		Pair<Node<Integer>, Node<Integer>> output= new Pair<Node<Integer>, Node<Integer>>();
		
		
		
		if(leftOutput.first!=null) {
			output.first=leftOutput.first;
			leftOutput.second.next=newNode;
		}else
			output.first=newNode;
		
		    newNode.next=rightOutput.first;
		if(rightOutput.first==null)
			output.second=newNode;
		else
			output.second=rightOutput.second;

			
		return output;
	}
	
	public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr, int n){
		
		return sortedArrayToBST(arr,0,arr.length-1);
		
	}
	
	private static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr, int si, int end) {
		
		int mid=(si+end)/2;
		
		BinaryTreeNode<Integer> node= new BinaryTreeNode<Integer>(arr[mid]);
		node.leftNode=sortedArrayToBST(arr, si,mid-1);
		node.rightNode=sortedArrayToBST(arr, mid+1, end);
		
		return node;
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
           
           return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
            
	}
	
	private static boolean isBST(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
          if(root==null)
        	  return true;
          
          if(root.data>minValue && root.data<=maxValue) {
        	  boolean ansLeft=isBST(root.leftNode,minValue,root.data);
        	  boolean ansright=isBST(root.rightNode, root.data, maxValue);
        	  return ansLeft&& ansright;
          }
        
		return false;
	}
	
	public static Pair<Boolean, Pair<Integer, Integer>> isBSTBetter(BinaryTreeNode<Integer> root) {
		if (root == null)
			return new Pair<Boolean, Pair<Integer, Integer>>(true,
					new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MIN_VALUE));// this means its sorted and is a
																						// binary tree

		Pair<Boolean, Pair<Integer, Integer>> leftNode = isBSTBetter(root.leftNode);
		Pair<Boolean, Pair<Integer, Integer>> rightNode = isBSTBetter(root.rightNode);

		int min = Math.min(root.data, Math.min(leftNode.second.first, rightNode.second.first));
		int max = Math.min(root.data, Math.max(leftNode.second.second, rightNode.second.second));

		boolean isBst = root.data > leftNode.second.second && root.data < rightNode.second.first && leftNode.first
				&& rightNode.first;
		return new Pair<Boolean, Pair<Integer, Integer>>(isBst, new Pair<Integer, Integer>(min, max));

	}

	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root==null)
			return ;
		
		if(k1>root.data )
		  elementsInRangeK1K2(root.rightNode, k1, k2);
		else if(k2<root.data)
		  elementsInRangeK1K2(root.leftNode, k1, k2);	
		else {
			  elementsInRangeK1K2(root.leftNode, k1, k2);
			  System.out.print(root.data+" ");
			  elementsInRangeK1K2(root.rightNode, k1, k2);	
			  
		}

		
	}
	
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		
		if (root == null)
			return false;

		if (root.data == k)
			return true;

		if (k < root.data)
			return searchInBST(root.leftNode, k);

		return searchInBST(root.rightNode, k);
	}

	private static BinaryTreeNode<Integer> takeInputlevelWise() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Root Data : ");
		int rootData = sc.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingQueues = new LinkedList<BinaryTreeNode<Integer>>();
		pendingQueues.add(root);

		while (!pendingQueues.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingQueues.poll();

			System.out.println("Enter the left node data for " + frontNode.data);
			int leftdata = sc.nextInt();
			if (leftdata != -1) {
				BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<Integer>(leftdata);
				pendingQueues.add(leftNode);
				frontNode.leftNode = leftNode;
			}

			System.out.println("Enter the right node data for " + frontNode.data);
			int rightdata = sc.nextInt();
			if (rightdata != -1) {
				BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<Integer>(rightdata);
				pendingQueues.add(rightNode);
				frontNode.rightNode = rightNode;
			}

		}

		return root;
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		Queue<BinaryTreeNode<Integer>> pendingQueues = new LinkedList<BinaryTreeNode<Integer>>();
		pendingQueues.add(root);

		while (!pendingQueues.isEmpty()) {
			BinaryTreeNode<Integer> front = pendingQueues.poll();
			System.out.print(front.data + ":");

			if (front.leftNode != null) {
				pendingQueues.add(front.leftNode);
				System.out.print("L:" + front.leftNode.data + ",");
			} else {
				System.out.print("L:-1" + ",");
			}

			if (front.rightNode != null) {
				pendingQueues.add(front.rightNode);
				System.out.print("R:" + front.rightNode.data);
			} else {
				System.out.print("R:-1");
			}

			System.out.println();
		}

	}
}
