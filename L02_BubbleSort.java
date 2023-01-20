package basic_class_01;

import java.util.Arrays;

// A[N] = { 5, 2, 6, 9, 3, 11, ... }
// first loop:
//   Compare A[0] with A[1], if greater, do swap; then
//   Compare A[1] with A[2], if greater, do swap; then
//   .......
//   Compare A[N-2] with A[N-1], if greater, do swap.
//   A[N-1] is largest number. Look like bubble pop up.
// second loop:
//   Do the same from A[0] to A[N-2]
// ........

//BigO
// N + (N-1) + (N-2) + .... + 1 = O(N^2)

public class Code_00_BubbleSort {
  
  public static void bubbleSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    for (int end=arr.length-1; end>0; end--) {
      for (int i=0; i<end; i++) {
        if (arr[i] > arr[i+1]) {
          swap(arr, i, i+1);
        }
      }
    }
  }
  
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
