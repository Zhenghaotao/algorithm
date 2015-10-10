package sort;

import javax.print.attribute.standard.Sides;

public class Solve {
	public static void main(String[] args) {
		Solve s = new Solve();
		int[] nums = new int[] { 1, 2, 3, 5, 2, 3 };
		s.countingSort(nums, 6);
		for (int i : nums) {
			System.out.print(i + "\t");
		}
	}

	/*********************************** 冒泡排序 *****************************************/
	public int[] bubbleSort(int[] A, int n) {
		if (A == null || n == 0) {
			return A;
		}
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					int tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
				}
			}
		}
		return A;
	}

	/************************************* 选择排序 **********************************************/
	public int[] selectionSort(int[] A, int n) {
		if (A == null || n == 0) {
			return A;
		}
		for (int i = 0; i < A.length - 1; i++) {
			int pos = i;
			for (int j = i + 1; j < A.length; j++) {
				if (A[pos] > A[j]) {
					pos = j;
				}
			}
			if (pos != i) {
				int tmp = A[i];
				A[i] = A[pos];
				A[pos] = tmp;
			}
		}
		return A;
	}

	/**************************************** 插入排序 *****************************/
	public int[] insertionSort(int[] A, int n) {
		if (A == null || n == 0) {
			return A;
		}
		for (int i = 1; i < n; i++) {
			int tmp = A[i];
			int j = i - 1;
			while (j >= 0 && tmp < A[j]) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = tmp;
		}
		return A;
	}

	/********************************** 归并排序 **********************************************/
	public int[] mergeSort(int[] A, int n) {
		if (A == null || n == 0) {
			return A;
		}
		sort(A, 0, n - 1);
		return A;
	}

	private void sort(int[] a, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			sort(a, left, mid);
			sort(a, mid + 1, right);
			mergeProcess(a, left, mid, right);

		}
	}

	private void mergeProcess(int[] a, int left, int mid, int right) {
		int[] newArr = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {// 每次循环，i和j不能同时++,否则结果不正确
			if (a[i] < a[j]) {
				newArr[k++] = a[i++];
			} else {
				newArr[k++] = a[j++];
			}
		}
		while (i <= mid) {
			newArr[k++] = a[i++];
		}
		while (j <= right) {
			newArr[k++] = a[j++];
		}
		for (k = 0, i = left; i <= right; i++, k++) {
			a[i] = newArr[k];
		}
	}

	/********************************** 快速排序 **********************************************/
	public int[] quickSort(int[] A, int n) {
		if (A == null || n == 0) {
			return A;
		}
		quicksort(A, 0, n - 1);

		return A;
	}

	private void quicksort(int[] a, int left, int right) {
		if (left < right) {
			int mid = getPartition(a, left, right);
			quicksort(a, left, mid - 1);
			quicksort(a, mid + 1, right);

		}
	}

	private int getPartition(int[] a, int left, int right) {
		int x = a[left];
		int i = left - 1;
		int j = right + 1;
		while (true) {
			while (a[++i] <= x && i < right)
				;
			while (a[--j] > x)
				;
			if (i >= j) {
				break;
			}
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		a[left] = a[j];
		a[j] = x;
		return j;
	}

	/********************************** 堆排序 **********************************************/
	public int[] heapSort(int[] A, int n) {
		if (A == null || n == 0) {
			return A;
		}
		for (int i = n - 1; i > 0; i--) {
			findMaxSort(A, i);
			int tmp = A[0];
			A[0] = A[i];
			A[i] = tmp;
		}
		return A;
	}

	private void findMaxSort(int[] a, int index) {
		for (int j = index; j > 0; j--) {
			int parent = (j - 1) / 2;
			int child = j;
			if (j < index && a[j] < a[j + 1]) {//j要小于索引值而并非 a.length - 1
				child++;
			}
			if (a[child] > a[parent]) {
				int tmp = a[child];
				a[child] = a[parent];
				a[parent] = tmp;
			}
		}
	}
	/********************************** 希尔排序 **********************************************/
	public int[] shellSort(int[] A, int n) {
		if(A == null || n == 0){
			return A;
		}
		for(int d = n /2; d >= 1; d /=2){//d为步长
			for(int i = n - 1; i >= 0; i--){
				for(int j = i - d; j >= 0 ; j-=d){
					if(A[i] < A[j]){
						int tmp = A[i];
						A[i] = A[j];
						A[j] = tmp;
					}
				}
			}
		}
		return A;
    }
	/****************************************计数排序*******************************************/
	public int[] countingSort(int[] A, int n) {
		if(A == null || n == 0){
			return A;
		}
		int max = A[0];
		for(int i = 1; i < n; i++){
			if(A[i] > max){
				max = A[i];
			}
		}
		int[] temp = new int[max + 1];
		for(int i = 0; i < n; i++){
			temp[A[i]]++;
		}
		int k = 0;
		for(int i = 0; i < temp.length; i++){
			while(temp[i]  > 0){
				A[k++] = i;
				temp[i]--;
			}
		}
		
		return A;
    }
}
