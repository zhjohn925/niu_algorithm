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
      // pick an random item (X), put it in the right-most. 
      // X is used to be middle number
      swap(arr, L + (int)(Math.random() * (R-L+1)), R);
      int[] p = partition(arr, L, R);
      quickSort(arr, L, p[0] - 1);
      quickSort(arr, p[1]+1, R);
    }
  }
  
  // use the last item (X, put in the middle) to divide the array
  // "<" on the left, "=X" in the middle, ">" on the right.
  public static int[] partition(int [] arr, int L, int R) {
    int less = L - 1;
    int more = R + 1;
    int cur = L;
    int num = arr[R];    // the right-most item as middle number
    while (cur < more) {
      if (arr[cur] < num) {
        swap(arr, ++less, cur++);
      } else if (arr[cur] > num) {
        swap(arr, --more, cur);
      } else {
        cur++;
      }
    }
    return new int[] { less + 1, more - 1};    // return "=" range. 
  }
  
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  } 
  
}

