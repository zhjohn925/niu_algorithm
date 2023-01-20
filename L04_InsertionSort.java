package basic_class_01;

import java.util.Arrays;

// Still USEFUL practically 

// Like the way you put(insert) a new card to your hand when playing card games.

// A[N] = { 5, 2, 6, 9, 3, 11, ... }
//   1st loop:  
//      A[0], do nothing
//   2nd loop: 
//      compare A[1] with A[0], if smaller, do swap
//   3rd loop:
//      compare A[2] with A[1], 
//      if greater, stop.
//      if smaller, do swap, then compare A[1] with A[0], if smaller, do swap.
//   4th loop:
//      compare A[3] with A[2],
//      if greater, stop. 
//      if smaller, do swap, then compare A[2] with A[1], ...
//   ......
//

// BigO has three cases depending on the initial array:
// 1. The A[N] is almost sorted, no/less swap() is called. then O(N)
// 2. The A[N] is inverted sorted (like, 6, 5, 4, 3, 2, 1),  swap() is called all the time, then O(N^2)
// 3. Average
// We need to pick the worst case, so O(N^2)

public class Code_01_InsertionSort {
  
  public static void insertionSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int i=1; i < arr.length; i++) {
      for (int j=i-1; j >= 0 && arr[j] > arr[j+1]; j--) {
        // save "break" line by putting compare in the for statement
        swap(arr, j, j+1);
      }
    }
  }
  
  public static void swap(int[] arr, int i, int j) {
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
  }
}
