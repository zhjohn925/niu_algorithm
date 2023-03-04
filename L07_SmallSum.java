
// 小和问题 (Using MergeSort)
// 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组的小和。
// Example：[1,3,4,2,5]
// 1左边比1小的数， 没有；
// 3左边比3小的数， 1；
// 4左边比4小的数， 1、 3；
// 2左边比2小的数， 1；
// 5左边比5小的数， 1、 3、 4、 2；
//
// 所以小和为1+1+3+1+1+3+4+2=16

// 如果直接用两层for循环扫一遍，时间复杂度O(N*N)，这个题目可以利用归并排序(Merge Sort)把时间复杂度降到O(N*logN)

public class SmallSum {
  
   public static int smallSum(int[] arr) {
      if (arr == null || arr.length < 2) {
          return 0;
      }
      return mergeSort(arr, 0, arr.length-1);
   }
     
   public static void mergeSort(int[] arr, int L, int R) {
      if (L == R) {
          return 0;
      }
      int mid = L + ((R-L) >> 1);
      return mergeSort(arr, L, mid)   +         // T(N/2)
             mergeSort(arr, mid+1, R) +         // T(N/2)
             merge(arr, L, mid, R);             // O(N) & Extra Space complexity O(N) using help[]
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




