package prog_assign03;

import java.util.Arrays;
import java.util.Random;

public class Prog03_1 {
	static int k = 1000;
	static int kk = 10000;
	static int kkk = 100000;
	static int [] random;
	static int [] reverse;
	static double res = 0;
	public static void main(String[] args) {
		System.out.println("         Random1000     Reverse1000     Random10000    Reverse10000     Random100000   Reverse100000     ");
		System.out.print("Bubble      ");
		bubble();
		ln();
		System.out.print("Selection   ");
		selection();
		ln();
		System.out.print("Insertion   ");
		insertion();
		ln();
		System.out.print("Merge       ");
		merge();
		ln();
		System.out.print("Quick1      ");
		quick1();
		ln();
		System.out.print("Quick2      ");
		quick2();
		ln();
		System.out.print("Quick3      ");
		quick3();
		ln();
		System.out.print("Heap        ");
		heap();
		ln();
		System.out.print("Library     ");
		library();
		ln();
	}
	private static void library() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + librarySort(random, i);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			printReverse(librarySort(reverse, i));
		}
	}
	private static double librarySort(int[] a, int i) {
		long start = System.currentTimeMillis();
		Arrays.parallelSort(a);
		long end = System.currentTimeMillis();
		return (end - start) / 1000.00;
	}
	private static void heap() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + heapSort(random, i);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			printReverse(heapSort(reverse, i));
		}
	}
	private static double heapSort(int[] a, int size) {
		long start = System.currentTimeMillis();
		buildMaxheap(a, size);
		for(int i = size-1; i >= 1;) {
			swap(a, 0, i);
			i--;
			maxHeapify(a, 0, i);
		}
		long end = System.currentTimeMillis();
		return (end - start) / 1000.00;
	}
	private static void buildMaxheap(int[] a, int n) {
		int i;
		int size = n - 1;
		if(size % 2 == 0)
			i = size / 2 - 1;
		else i = size / 2;
		for(int j = i; j >= 0; j--) {
			maxHeapify(a, j, size);
		}
	}
	private static void maxHeapify(int[] a, int i, int n) {
		while(i * 2 + 1 <= n) {
			int k = i * 2 + 1;
			if(k + 1 <= n && a[k] < a[k+1])
				k++;
			if(a[i] >= a[k])
				return;
			swap(a, i, k);
			i = k;
		}
	}
	private static void ln() {
		System.out.println();
	}
	private static void insertion() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + insertionSort(random, i);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			printReverse(insertionSort(reverse, i));
		}
	}
	private static double insertionSort(int[] a, int size) {
		long start = System.currentTimeMillis();
		for(int i = 1; i< size; i++) {
			int tmp = a[i];
			int cp = i-1;
			while(cp >= 0 && tmp < a[cp]) {
				a[cp+1] = a[cp];
				cp--;
			}
			a[cp+1] = tmp;
		}
		long end = System.currentTimeMillis();
		return (end - start) / 1000.00;
	}
	private static void quick3() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				Random num = new Random();
				int n = num.nextInt(i+1);
				newRandom(i);
				res = res + quickRandom(random, 0, i-1, n);
			}
			printRandom(res);
			Random num = new Random();
			int n = num.nextInt(i+1);
			newReverse(i);
			res = 0;
			if(i == kkk)
				break;
			printReverse(quickRandom(reverse, 0, i-1, n));
		}
	}
	private static double quickRandom(int[] a, int p, int r, int n) {
		long start = System.currentTimeMillis();
		if(p < r) {
			int q = partRandom(a, p, r, n);
			quickLast(a, p, q-1);
			quickLast(a, q+1, r);
		}
		long end = System.currentTimeMillis();
		return (end-start) / 1000.00;
	}
	private static int partRandom(int[] a, int begin, int last, int n) {
		int pv = a[n];
		int i = begin - 1;
		for(int j = begin; j < last; j++) {
			if(a[j] <= pv) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, last);
		return i+1;
	}
	private static void quick2() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + quickMid(random, 0, i-1);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			if(i == kkk)
				break;
			printReverse(quickMid(reverse, 0, i-1));
		}
	}
	private static double quickMid(int[] a, int p, int r) {
		int mid = (p+r)/2;		
		long start = System.currentTimeMillis();
		medianSwap(a, p, mid, r);
		sortMid(a, p, r);
		long end = System.currentTimeMillis();
		return (end-start) / 1000.00;
	}
	private static void sortMid(int[] a, int p, int r) {
		if(p < r) {
			int q = partMid(a, p, r);
			sortMid(a, p, q-1);
			sortMid(a, q+1, r);
		}
	}
	private static int partMid(int[] a, int begin, int last) {
		int mid = (begin+last)/2;
		int pv = a[mid];
		swap(a, mid, last-1);
		int i = begin - 1;
		for(int j = begin; j < last; j++) {
			if(a[j] <= pv) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, last);
		return i+1;
	}
	private static void medianSwap(int[] a, int p, int mid, int r) {
		if(a[p] > a[mid]) swap(a, p, mid);
		if(a[mid] > a[r]) swap(a, mid, r);
		if(a[p] > a[mid]) swap(a, p, mid);
	}
	private static void quick1() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + quickLast(random, 0, i-1);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			if(i == kkk)
				break;
			printReverse(quickLast(reverse, 0, i-1));
		}
	}
	private static double quickLast(int[] a, int p, int r) {
		long start = System.currentTimeMillis();
		if(p < r) {
			int q = partLast(a, p, r);
			quickLast(a, p, q-1);
			quickLast(a, q+1, r);
		}
		long end = System.currentTimeMillis();
		return (end-start) / 1000.00;
	}
	private static int partLast(int[] a, int begin, int last) {
		int pv = a[last];
		int i = begin - 1;
		for(int j = begin; j < last; j++) {
			if(a[j] <= pv) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, last);
		return i+1;
	}
	private static void merge() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + mergeSort(random, 0, i-1);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			printReverse(mergeSort(reverse, 0, i-1));
		}
	}
	private static double mergeSort(int[] a, int p, int r) {
		int mid;
		long start = System.currentTimeMillis();
		if(p < r) {
			mid = (p+r) / 2;
			mergeSort(a, p, mid);
			mergeSort(a, mid+1, r);
			mergeArray(a, p, mid, r);
		}
		long end = System.currentTimeMillis();
		return (end-start)/1000.00;
	}
	private static void mergeArray(int[] a, int p, int mid, int r) {
		int i, j, k, t;
		i = p;
		j = mid + 1;
		k = p;
		int [] sorted = new int[r+1];
		while (i <= mid && j <= r) {
			if(a[i] < a[j])
				sorted[k] = a[i++];
			else
				sorted[k] = a[j++];
			k++;
		}
		if(i > mid) {
			for(t = j; t <= r; t++, k++)
				sorted[k] = a[t];
		}
		else {
			for(t = i; t <= mid; t++, k++)
				sorted[k] = a[t];
		}
		for(t = p; t <= r; t++)
			a[t] = sorted[t];
	}
	private static void selection() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + selectionSort(random, i);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			printReverse(selectionSort(reverse, i));
		}
	}
	private static double selectionSort(int[] a, int size) {
		int max, count;
		long start = System.currentTimeMillis();
		for(int i = size-1; i > 0; i--) {
			max = a[i];
			count = i;
			for(int j = 0; j < i; j++) {
				if(a[j]>max) {
					max = a[j];
					count = j;
				}					
			}
			swap(a, i, count);					
		}
		long end = System.currentTimeMillis();
		return (end-start) / 1000.00;
	}
	private static void bubble() {
		for(int i = k; i < kkk+1; i*=10) {
			res = 0;
			for(int j = 0; j < 10; j++) {
				newRandom(i);
				res = res + bubbleSort(random, i);
			}
			printRandom(res);
			newReverse(i);
			res = 0;
			printReverse(bubbleSort(reverse, i));
		}
	}
	private static void printReverse(double anwser) {
		System.out.printf("%.5f         ", anwser);
	}
	private static void newReverse(int size) {
		reverse = new int[size];
		for(int i = 0; i < size; i++)
			reverse[i] = size - i;
	}
	private static void printRandom(double anwser) {
		System.out.printf("%.5f         ", anwser/10);
	}
	private static double bubbleSort(int[] a, int size) {
		long start = System.currentTimeMillis();
		for(int i = size-1; i > 0; i--) {
			for(int j = 0; j < i; j++)
				if(a[j] > a[j+1])
					swap(a, j, j+1);
		}
		long end = System.currentTimeMillis();
		return (end-start) / 1000.00;
	}
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	private static void newRandom(int size) {
		Random num = new Random();
		random = new int[size];
		for(int i = 0; i < size; i++)
			random[i] = num.nextInt(size+1);
	}
}
