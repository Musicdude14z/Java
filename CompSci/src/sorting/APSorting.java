package sorting;

import java.util.Arrays;

public class APSorting {
	
	public static void main(String[] args) {
		int[] test = new int[10];
		for(int i=0; i<test.length; i++) {
			test[i] = (int)(Math.random()*100+1);
		}
		
		int[] bubbleTest = Arrays.copyOf(test, test.length);
		bubbleSort(bubbleTest);
		
		int[] selectionTest = Arrays.copyOf(test, test.length);
		selectionSort(selectionTest);
		
		int[] insertionTest = Arrays.copyOf(test, test.length);
		insertionSort(insertionTest);
		
		int[] mergeTest = Arrays.copyOf(test, test.length);
		mergeSort(mergeTest);
		
		int[] quickTest = Arrays.copyOf(test, test.length);
		quickSort(quickTest);
		
		System.out.println(Arrays.toString(test));
		System.out.println(Arrays.toString(bubbleTest));
		System.out.println(Arrays.toString(selectionTest));
		System.out.println(Arrays.toString(insertionTest));
		System.out.println(Arrays.toString(mergeTest));
		System.out.println(Arrays.toString(quickTest));
	}
	
	public static void swap(int[] a, int i, int j) {
		a[i] ^= a[j];
		a[j] ^= a[i];
		a[i] ^= a[j];
	}
	
	public static void bubbleSort(int[] a) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i=1; i<a.length; i++) {
				if(a[i] < a[i-1]) {
					swap(a, i, i-1);
					sorted = false;
				}
			}
		}
	}
	
	public static void selectionSort(int[] a) {
		int min, pos;
		for(int i=0; i<a.length-1; i++) {
			min = a[pos=i];
			for(int j=i+1; j<a.length; j++) {
				if(a[j] < min) {
					min = a[pos=j];
				}
			}
			if(pos != i) swap(a, i, pos);
		}
	}
	
	public static void insertionSort(int[] a) {
		for(int i=1; i<a.length; i++) {
			for(int j=i; j>0 && a[j] < a[j-1]; j--) {
				swap(a, j, j-1);
			}
		}
	}
	
	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length);
	}
	
	public static void mergeSort(int[] a, int start, int end) {
		if(end-start < 2) return;
		int m = start + (end-start)/2;
		mergeSort(a, start, m);
		mergeSort(a, m, end);
		for(int i=end/2; i<end; i++) {
			for(int j=i; j>0 && a[j] < a[j-1]; j--) {
				swap(a, j, j-1);
			}
		}
	}
	
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length);
	}
	
	public static void quickSort(int[] a, int start, int end) {
		switch(end-start) {
		case 1: return;
		case 2:
			if(a[start] > a[start+1]) swap(a, start, start+1);
			return;
		}
		int f = start+1, e = end-1, p = start;
		//System.out.printf("%d, %d\n", f, e);
		while(true) {
			while(f < e && a[f] <= a[p]) f++;
			while(e > f && a[e] >= a[p]) e--;
			if(e == f) break;
			swap(a, p, f); //moves pivot towards 'center'
			swap(a, p, e); //swaps both values
			p = f;
		}
		//System.out.printf("==> %s | p = %d\n", Arrays.toString(a), a[f]);
		quickSort(a, start, f);
		quickSort(a, e, end);
	}
	
}
