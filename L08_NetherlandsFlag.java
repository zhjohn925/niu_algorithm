// Time complexity O(N)

//        L                                        R
//       +------------------------------------------+
//  less |  < num        |    = num    |   > num    | more 
//       +------------------------------------------+ 
//       cur-->
//
//  0 ~ less   :  < num.    if arr[L] < num, increment less, do swap less <-> L, then increment L 
//  more ~ end :  > num.    if arr[L] > num, decremant more, do swap L <-> more. 
//  between    :  = num.    if arr[L] = num, increment L.

public class NetherlandsFlag {
  
  public static int[] partition(int [] arr, int L, int R, int num) {
    int less = L - 1;
    int more = R + 1;
    int cur = L;
    while (cur < more) {
      if (arr[cur] < num) {
        swap(arr, ++less, cur++);
      } else if (arr[cur] > num) {
        swap(arr, --more, cur);
      } else {
        cur++;
      }
    }
    return new int[] { less + 1, more - 1};
  }
  
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
