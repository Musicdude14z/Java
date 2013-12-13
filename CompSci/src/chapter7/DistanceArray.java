package chapter7;

import java.util.Arrays;

/**
 * @author Zach Kaplan
 * @version 2.0
 */
public class DistanceArray {

	/**
	 * Main Method
	 * @param args - input
	 */
	public static void main(String[] args) {
		int[][] distances = {
				{0, 983, 787, 714, 1375, 967, 1087},
				{983, 0, 214, 1102, 1763, 1723, 1842},
				{787, 214, 0, 888, 1549, 1548, 1627},
				{714, 1102, 888, 0, 661, 781, 810},
				{1375, 1763, 1549, 661, 0, 1426, 1187},
				{967, 1723, 1548, 781, 1426, 0, 239},
				{1087, 1842, 1627, 810, 1187, 239, 0}
		};
		System.out.println("Print Distances:");
		for(int[] arr : distances) {
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println("Sum of Distances:");
		System.out.println(sum(distances));
		
		System.out.println("Random 2D Array");
		int[][] rand = rand2DArr(10, 10);
		for(int[] arr : rand) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	/**
	 * Sums a 2D int array
	 * @param arr - 2D array
	 * @return the sum
	 */
	private static int sum(int[][] arr) {
		int sum = 0;
		for(int[] a : arr) {
			for(int i : a) {
				sum += i;
			}
		}
		return sum;
	}
	
	/**
	 * Generates 2D array of a x b, with random integers from 0 to 99 inclusive
	 * in all positions
	 * @param a - number of rows
	 * @param b - number of columns
	 * @return the random array
	 */
	private static int[][] rand2DArr(int a, int b) {
		int[][] rand = new int[a][];
		for(int j=0; j<10; j++) {
			int[] arr = new int[b];
			for(int i=0; i<arr.length; i++) {
				arr[i] = (int)(Math.random()*100);
			}
			rand[j] = arr;
		}
		return rand;
	}

}
