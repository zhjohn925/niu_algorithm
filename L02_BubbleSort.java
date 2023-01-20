package basic_class_01;

import java.util.Arrays;

// NOT USEFUL practically 

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
  
  // ------------------------------------------------
  // for test
  // ------------------------------------------------
  
  // generate array with random size, and random values
  public static int[] generateRandomArray(int size, int value) {
    // Math.random() -> double [0,1)
    // (int)((size+1)*Math.random())  --> [0, size]
    int[] arr = new int[(int)((size+1)*Math.random())];
    for (int i=0; i<arr.length; i++) {
      arr[i] = (int)((value+1) * Math.random()) - (int) (value*Math.random());
    }
    return arr;
  }
  
  // call library sort() to get sorted array for reference
  public static void rightMethod(int[] arr) {
    Arrays.sort(arr);
  }
  
  public static int[] copyArray(int[] arr) {
    if (arr == null) return null;
    int[] res = new int[arr.length];
    for (int i=0; i<arr.length; i++) {
      res[i] = arr[i];
    }
    return res;
  }
  
  public static boolean isEqual(int[] arr1, int[] arr2) {
    if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
      return false;
    }
    if (arr1 == null && arr2 == null) {
      return true;
    }
    if (arr1.length != arr2.length) {
      return false;
    }
    for (int i=0; i<arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
  
  public static void printArray(int[] arr) {
    if (arr == null) return;
    for (int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
  
  
  public static void main(String[] args) {
    int testTime = 500000;
    int size = 10;
    int value = 100;
    boolean succeed = true;
    for (int i=0; i<testTime; i++) {
      int[] arr1 = generateRandomArray(size, value);
      int[] arr2 = copyArray(arr1);
      int[] arr3 = copyArray(arr1);
      bubbleSort(arr1);
      rightMathod(arr2);
      if (!isEqual(arr1, arr2)) {
        succeed = false;
        printArray(arr3);
        break;
      }
    }
    System.out.println(succeed ? "Nice!" : "Bad!");
  
}
