package basic_class_01;

import java.util.Arrays;

// NOT USEFUL practically 

// A[N] = { 5, 2, 6, 9, 3, 11, ... }
// first loop:
//   look for index [0..N-1] with smallest value, switch with A[0]
// second loop:
//   look for index [1..N-1] with smallest value, switch with A[1]
// ........

//BigO
// N + (N-1) + (N-2) + .... + 1 = O(N^2)

public class Code_02_SelectionSort {
  
  public static void selectionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int i=0; i<arr.length-1; i++) {
      int minIndex = i;
      for (int j=i+1; j<arr.length; j++) {
        minIndex = arr[j] < arr[minIndex] ? j : minIndex;
      }
      swap(arr, i, minIndex);
    }
  }
  
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
