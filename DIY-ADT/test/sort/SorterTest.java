package sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SorterTest {
	
	Sorter s = new Sorter();
	Object[] arr = {"26","53","48","01","03","38","32","15","09","26"};
	Object[] arr1 = {"--","26","53","48","01","03","38","32","15","09","26"};
	
	Object[] a1 = {"1","3","5","7","2","4","7","8"};
	@Test
	public void testInsertSort() {
//		s.insertSort(arr, 0, arr.length - 1);
//		s.binInsertSort(arr, 0, arr.length - 1);
//		s.shellSort(arr, 0, arr.length - 1);
//		s.bubbleSort(arr, 0, arr.length - 1);
//		s.quickSort(arr, 0, arr.length - 1);
//		s.selectSort(arr, 0, arr.length - 1);
		
//		s.heapSort(arr1);
//		System.out.println(Arrays.toString(arr1));
		
//		s.merge(a1, 0, 3, a1.length-1);
//		System.out.println(Arrays.toString(a1));
		
		s.mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
