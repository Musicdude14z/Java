import java.util.Arrays;

public class Quicksort {

	public static void main(String[] args) {
		int[] arr = {1, -1, 1, 1, -1, 1, -1, -1, 1, 0, -1, 1, 0, -1, 0, -1, 1, 1, -1, 1, 0, -1, 0, -1};
		System.out.println(Arrays.toString(partition2(arr)));
		System.out.println(Arrays.toString(partition3(arr)));
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * rearranges entries in array a to partition them such that small numbers
	 * on at the front and large at the back
	 *
	 * @returns pivot such that 
	 *          forall k, left <= k <= pivot, a[k] <= a[pivot] and
	 *          forall k, pivot < k <= right, a[pivot] < a[k]
	 */
	public static int[] partition2 (int[] a) {
		int lastPos = -1;
		for(int i=1; i<a.length; i++) {
			if(a[i]>a[0]) {
				for(int j=i+1; j<a.length; j++) {
					if(a[j]<=a[0]) {
						swap(a, i, j);
						lastPos = i;
						break;
					}
				}
			}else {
				lastPos = i;
			}
		}
		if(lastPos < 0) return a;
		swap(a, 0, lastPos);
		return a;
	}

	
	// TODO: FIX
	public static int[] partition3 (int[] a) {
		int pivot = a[0];
		for(int i=0; i<a.length; i++) {
			if(a[i] == pivot) {
				for(int j=i+1; j<a.length; j++) {
					if(a[j] < pivot) {
						swap(a, i, j);
						break;
					}
				}
			}else if(a[i] > pivot) {
				for(int j=a.length-1; j>i; j--) {
					if(a[j] < pivot) {
						swap(a, i, j);
						break;
					}
				}
			}
		}
		return a;
	}

}
