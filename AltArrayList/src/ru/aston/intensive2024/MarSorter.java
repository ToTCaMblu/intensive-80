package ru.aston.intensive2024;

public class MarSorter {
	
	/**
	 * @param <T> type
	 * @param list instance of MarrayList
	 */
	public static <T> void qsortArray (MarrayList<T> list) {
		quicksort ((Comparable[]) list.toArray(), 0, list.size()-1) ;
		System.out.println("Array sorted by quicksort!");
	}
	
	private static void quicksort (Comparable[] array, int start, int end) {

	    if(array != null && array.length <= 1) {
	      return;
	    }

	    if (start < end) {

	      int pivotIndex = partition(array, start, end);
	      quicksort(array, start, pivotIndex - 1);
	      quicksort(array, pivotIndex + 1, end);
	    }
	  }
	
	  private static int partition(Comparable[] array, int start, int end) {

		    Comparable pivot = array[start];
		    int i = start;
		    for (int j = start + 1; j <= end; j++) {
		      if (array[j].compareTo(pivot) < 0) {
		        i++;
		        swap(array, i, j);
		      }
		    }
		    swap(array, start, i);
		    return i;
		  }

	  private static void swap(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }	  

}
