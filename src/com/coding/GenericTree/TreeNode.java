package com.coding.GenericTree;

import java.util.ArrayList;

public class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> next = null;

	public TreeNode(T data) {
		this.next = new ArrayList<TreeNode<T>>();
		this.data = data;
	}

}
