// find max number in an array
//     - Based on L05_Recursive_complexity.png, 
//     - Complexity:  
//         Total of N, divided to two halves ===> b=2
//         Process Left (getMax) and Right (getMax) ===> a=2
//         Compare maxLeft and maxRight ===> this is constand, so O(1) ===> d=0
//         
//         

public class FindMax {
   public static int getMax(int[] arr, int L, int R) {
      if (L==R) return arr[L];
      int mid = (L+R)/2;
      int maxLeft = getMax(arr, L, mid);
      int maxRight = getMax(arr, mid+1, R);
      return Math.max(maxLeft, maxRight);
   }
   
   public static void main(String[] args) {
      int[] arr = {4, 3, 2, 1};
      System.out.println(getMax(arr, 0, arr.length-1));
   }
}
