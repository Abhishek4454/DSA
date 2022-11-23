package com.coding.recursionNew;

import java.util.Arrays;

public class QuickSortXXX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = { 12, 3, 14, 15, 4, 7, 8, 11 };
		System.out.println(Arrays.toString(input));
		quickSort(input);
		System.out.println(Arrays.toString(input));
	}

	private static void quickSort(int[] input) {
		quickSort(input,0,input.length-1);
	}

	private static void quickSort(int[] input, int start, int end) {
		// TODO Auto-generated method stub
		
		if(start>=end)
			return ;
		
		int pivPos=partition(input,start,end);
		quickSort(input, start, pivPos-1);
		quickSort(input, pivPos+1,end);
		
	}

	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end]; 
        int i = (start-1); // index of smaller element
        for (int j=start; j<end; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
  
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
            }
        }
  
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
  
        return i+1;
		
		
	}

}
