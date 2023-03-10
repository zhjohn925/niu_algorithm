// Time Complexity O(N*LogN)
// Extra Space Complexity O(logN)

// Use NetherlandsFlag to do QuickSort

import java.util.Arrays;

public class QuickSort {
  
  public static void quickSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    quickSort(arr, 0, arr.length-1);
  }
  
  public static void quickSort(int[] arr, int L, int R) {
    if (L < R) {
      swap(arr, L + (int)(Math.random() * (R-L+1)), R);
      int[] p = partition(arr, L, R);
      quickSort(arr, L, p[0] - 1);
      quickSort(arr, p[1]+1, R);
    }
  }
  
  
  
}

