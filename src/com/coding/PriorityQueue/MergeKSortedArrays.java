package com.coding.PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

	public static ArrayList<Integer> mergeKSortedArraysBetter(ArrayList<ArrayList<Integer>> input) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		for (int i = 0; i < input.size(); i++) {
			Pair p = new Pair(i, 0, input.get(i).get(0));
			pq.add(p);
		}

		while (pq.size()>0) {
			Pair p = pq.remove();
			list.add(p.val);
			p.si++;

			if (p.si < input.get(p.li).size()) {
				p.val = input.get(p.li).get(p.si);
				pq.add(p);
			}

		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(5);
		list1.add(9);
		list2.add(45);
		list2.add(90);
		list3.add(2);
		list3.add(6);
		list3.add(78);
		list3.add(100);
		list3.add(238);
		input.add(list1);
		input.add(list2);
		input.add(list3);
		System.out.println(mergeKSortedArraysBetter(input));

	}

	// Brut Force
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(i).size(); j++) {
				heap.add(input.get(i).get(j));
			}
		}
		while (!heap.isEmpty())
			list.add(heap.remove());

		return list;

	}

}

class Pair implements Comparable<Pair> {
	int li;
	int si;
	int val;

	public Pair(int li, int si, int val) {
		super();
		this.li = li;
		this.si = si;
		this.val = val;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.val - o.val;
	}

}
