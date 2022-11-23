package com.coding.PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		int k = 4;
		System.out.println(kLargest(arr, k));
		System.out.println(kSmallest(arr.length, arr, k));

	}

	public static int kthLargest(int n, int[] input, int k) {
		// Write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(input[i]);
		}
		k = n - k;
		while (k > 0) {
			pq.poll();
			k--;
		}
		return pq.peek();
	}

	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		// Write your code here
		ArrayList<Integer> ans = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int i = 0;
		for (; i < k; i++) {
			pq.add(input[i]);// Assume first k elements are largest
		}

		for (; i < input.length; i++) {
			if (input[i] < pq.peek()) {
				pq.remove();
				pq.add(input[i]);
			}

		}
		while (!pq.isEmpty()) {
			ans.add(pq.remove());
		}
		Collections.reverse(ans);
		return ans;
	}

	public static ArrayList<Integer> kLargest(int input[], int k) {

		ArrayList<Integer> ans = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i = 0;
		for (; i < k; i++) {
			pq.add(input[i]);// Assume first k elements are largest
		}

		for (; i < input.length; i++) {
			int min = pq.element();// calculate min of them
			if (min < input[i]) {// compare if min is smaller than next
				pq.remove();// remove min as we need to get the largest
				pq.add(input[i]);// add to the pq
			}

		}
		while (!pq.isEmpty()) {
			ans.add(pq.remove());
		}
		return ans;
	}
}
