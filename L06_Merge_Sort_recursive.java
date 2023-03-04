// Time Complexity O(N*logN)
// Space Complexity O(N)

// Based on L05_Recursive_complexity.png, 
// T(N) = 2*T(N/2) + O(N)   ====> O(N*LogN)

//  arr = { 5,3,6,1,9,7}
//  1. divided into two halves, then sort    ==> 2*T(N/2)
//     3,5,6  |  1,7,9
//     p1        p2
//  2. use a helper array to merge. when p1 (or p2) reaches to the end         ====> O(N)
//     just copy remaining in the other side (ie. 7, 9 from the right half)
//     helper = 1,3,5,6,[7,9]
//  3. copy helper to arr
//     arr = 1,3,5,6,7,9

public class MergeSort {
   public static void mergeSort(int[] arr) {
      if (arr==null || arr.length < 2) {
          return;
      }
      sortProcess(arr, 0, arr.length-1);
   }
  
   public static void sortProcess(int[] arr, int L, int R) {
      if (L==R) return;
      int mid = L + ((R-L) >> 1);
      sortProcess(arr, L, mid);         // T(N/2)
      sortProcess(arr, mid+1, R);       // T(N/2)
      merge(arr, L, mid, R);            // O(N) & Space complexity O(N) using help[]
   }
    
   public static void merge(int[] arr, int L, int mid, int R) {
      int [] help = new int[R-L+1];
      int i=0; 
      int p1=L;
      int p2=mid+1;
      while (p1<=mid && p2<=R) {
         help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
      }
      while (p1<=mid) {
         help[i++] = arr[p1++];
      }
      while (p2<=R) {
         help[i++] = arr[p2++];
      }     
      for (i=0; i<help.length; i++) {
         arr[L+i] = help[i];
      }
   }
  
}
