package com.coding.OOPS;

public class DynamicArray {
    
	private int[] data;
	private int nextdata;
	
	public DynamicArray() {
		data=new int[5];
		nextdata=0;
		
	}

	public int size() {
		return nextdata;
	}
	public void add(int element) {
		if(nextdata==data.length)
			restructure();
		
			data[nextdata++]=element;
		
	}
	public void set(int index,int value) {
		if(index>nextdata) 
			return;
		if(index<nextdata)
			data[index]=value;
		else
			add(value);
	}
	public int get(int index) {
		if(index>=data.length)
			return -1;
		else
			return data[index];
	}

	private void restructure() {
		int temp[]=data;
        data=new int[data.length * 2];
        for (int i = 0; i < temp.length; i++) {
			data[i]=temp[i];
		}
	}
	
	public static void main(String[] args) {
		DynamicArray d= new DynamicArray();
		for(int i=0;i<100;i++) {
			d.add(i+10);
			System.out.print(d.get(i)+" ");
		}
		System.out.println();
		System.out.println(d.size());

	}
}
