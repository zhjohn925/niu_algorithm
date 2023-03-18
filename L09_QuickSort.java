// Time Complexity O(N*LogN)
// Extra Space Complexity O(logN)

// Use NetherlandsFlag to do QuickSort
// Pick last item X to divide the array in the format of
//           < X  ||  = X  ||  > X
//
// This classic quick sort in best case gives time complexity O(N*LogN). 
//    When X is picked to divide the array evenly, the number of items in left half (<X) 
//    is equal to the number of items in the right half (>X). 
//    T(N) = 2*T(N/2) + O(N)   ===>  O(N*logN)
// and, in worst case if an array is almost sorted,  can result time complexity O(N^2).
//    Every partition/loop has no swap, therefore, one loop only sets one item. 
//    { 1, 2, 3, 4, 5, 6, 7 }  OR { 7, 6, 5, 4, 3, 2, 1 }
// To resolve this issue, pick a random item X to divide the array. Time complexity depends on 
// probability. (see line 33)

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
      //p is low index and high index of the middle range (=X)
      int[] p = partition(arr, L, R);       // <== Extra Space Complexity O(logN)
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

