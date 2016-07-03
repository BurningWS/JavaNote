package sort;

import strategy.DefaultStrategy;
import strategy.Strategy;

public class Sorter {
	private Strategy strategy;

	public Sorter() {
		this(new DefaultStrategy());
	}

	public Sorter(Strategy strategy) {
		this.strategy = strategy;
	}

	// 简单插入排序
	public void insertSort(Object[] r, int low, int high) {
		for (int i = low + 1; i <= high; i++) {
			int k = i;
			Object tmp = r[k];
			while (k > 0 && strategy.compare(tmp, r[k - 1]) < 0) {
				r[k] = r[k - 1];
				k--;
			}
			r[k] = tmp;
		}
	}

	// 折半插入排序
	public void binInsertSort(Object[] r, int low, int high) {
		for (int i = low + 1; i <= high; i++) {
			Object tmp = r[i];

			int l = 0, h = i - 1;
			while (l <= h) {
				int mid = (l + h) / 2;
				if (strategy.compare(tmp, r[mid]) < 0)
					h = mid - 1;
				else
					l = mid + 1;
			}

			for (int j = i; j > h + 1; j--)
				r[j] = r[j - 1];

			r[h + 1] = tmp;
		}
	}

	// 希尔排序
	public void shellSort(Object[] r, int low, int high) {
		int delta = (high - low + 1) / 2;
		while (delta > 0) {
			for (int i = delta; i < r.length; i++) {
				int k = i;
				Object tmp = r[k];
				while (k - delta >= 0
						&& strategy.compare(tmp, r[k - delta]) < 0) {
					r[k] = r[k - delta];
					k -= delta;
				}
				r[k] = tmp;
			}
			delta /= 2;
		}
	}

	// 起泡排序
	public void bubbleSort(Object[] r, int low, int high) {
		boolean flag = true;
		for (int i = 0; i < high && flag; i++) {
			flag = false;
			for (int j = high; j > i; j--) {
				if (strategy.compare(r[j], r[j - 1]) < 0) {
					Object tmp = r[j];
					r[j] = r[j - 1];
					r[j - 1] = tmp;
					flag = true;
				}
			}
		}
	}

	// 快速排序
	public void quickSort(Object[] r, int low, int high) {
		if (low >= high)
			return;
		Object tmp = r[low];
		int i = low, j = high;
		while (j > i) {
			while (j > i && strategy.compare(tmp, r[j]) <= 0) {
				j--;
			}
			r[i] = r[j];
			while (j > i && strategy.compare(r[i], tmp) <= 0) {
				i++;
			}
			r[j] = r[i];
		}
		r[i] = tmp;
		quickSort(r, low, i - 1);
		quickSort(r, i + 1, high);
	}

	// 选择排序
	public void selectSort(Object[] r, int low, int high) {
		for (int i = low; i < high; i++) {
			for (int j = i + 1; j <= high; j++) {
				if (strategy.compare(r[i], r[j]) > 0) {
					Object tmp = r[i];
					r[i] = r[j];
					r[j] = tmp;
				}
			}
		}
	}

	// 堆排序
	public void heapSort(Object[] r) {
		int n = r.length - 1;
		for (int i = n / 2; i > 0; i--) {
			heapAdjust(r, i, n);
		}
		for (int i = n; i > 1; i--) {
			Object tmp = r[i];
			r[i] = r[1];
			r[1] = tmp;
			heapAdjust(r, 1, i - 1);
		}
	}

	private void heapAdjust(Object[] r, int low, int high) {
		int i = low;
		for (int j = 2 * i; j <= high; j *= 2) {
			if (j < high && strategy.compare(r[j], r[j + 1]) < 0)
				j++;
			if (strategy.compare(r[j], r[i]) > 0) {
				Object tmp = r[j];
				r[j] = r[i];
				r[i] = tmp;
				i = j;
			} else
				break;
		}
	}

	// 归并排序
	public void mergeSort(Object[] r, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(r, low, mid);
			mergeSort(r, mid + 1, high);
			merge(r, low, mid, high);
		}
	}

	public void merge(Object[] a, int p, int q, int r) {
		Object[] b = new Object[r - p + 1];
		int i = p, j = q + 1, k = 0;
		while (i <= q && j <= r) {
			if (strategy.compare(a[i], a[j]) <= 0)
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}
		while (i <= q) {
			b[k++] = a[i++];
		}
		while (j <= r) {
			b[k++] = a[j++];
		}
		for (int t = 0; t < b.length; t++) {
			a[p+t] = b[t];
		}
	}
}
