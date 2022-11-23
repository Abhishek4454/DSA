package com.coding.BinaryTree;

public class CustomBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static BinaryTreeNode<Integer> root;
	public static boolean hasElement(int data) {
		
		return hasElement(data,root);
		
	}
	private static boolean hasElement(int data, BinaryTreeNode<Integer> root) {
		
		if(root.data==null)
			return false;
		
		if(root.data==data)
			return true;
		
		if(root.data>data)
			return hasElement(data,root.leftNode);
		
		else
			return hasElement(data,root.rightNode);
		
	}
	
	public static void insert(int data) {
		root=insert(data,root);
	}
	private static BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if(root==null) {
			root=new BinaryTreeNode<Integer>(data);
			return root;
		}
		if(data>root.data) {
			return insert(data, root.rightNode);
		}else {
			return insert(data, root.leftNode);
		}
		
	}
	
	public static void delete(int data) {
		root=delete(data,root);
	}
	private static BinaryTreeNode<Integer> delete(int data, BinaryTreeNode<Integer> root) {
		if(root==null)
			return null;
		
		if(data>root.data) {
			return delete(data, root.rightNode);
		}
		else if(data<root.data) {
			return delete(data, root.leftNode);
		}else {
			if(root.rightNode==null && root.leftNode==null)
				return null;
			else if(root.rightNode==null)
				return root.leftNode;
			else if(root.leftNode==null)
				return root.rightNode;
			else {
				BinaryTreeNode<Integer> minNode=root.rightNode;
				while(minNode!=null) {
					minNode= minNode.leftNode;
				}
				root.data= minNode.data;
				root.rightNode=delete(minNode.data, root.rightNode);
				return root;
			}
			
		}
	   
	}

}
