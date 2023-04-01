2:16:52
// Complete binary tree
//   - A node can be Leaf node (no child), or has left child, or has left child and right child
//   - Parent node (i) has left child node (2*i+1), and right child node (2*i+2)
//   - Child node (i) has parent node (i-1)/2
//                0
//             /    \
//           1       2
//          /  \    /
//        3     4  5
//
//   - Consider an array as a complete binary tree.

//  Two different types of heap data structures. (as Complete binary tree)
//     - "大根堆" (dà gēn duī) is commonly translated as "max heap". In a max heap, the maximum element 
//       is always stored at the root of the heap (every sub tree).
//     - "小根堆" (xiǎo gēn duī) is commonly translated as "min heap". In a min heap, the minimum element 
//       is always stored at the root of the heap (every sub tree).

//  Example: 
//         Array { 3, 4, 5, 1, 2 } as Complete binary tree:
//                  3
//                /   \
//               4     5       Obviously this is not a max heap (大根堆)
//             /   \
//            1     2

//  Example( heapInsert() ): Change it to max heap (大根堆)
//      Array { 2, 1, 3, 6, 0, 4 } as Complete binary tree:
//      Change to max heap from 0 to i, forwarding i to the end. 
//         2       2        2             3             3                3               6
//               /        /   \  -->    /   \         /   \    -->     /   \   -->      /  \         ::::::;
//              1        1     3       1     2       1     2          6     2          3    2
//                     do swap with parent node     /                /                /
//                                                 6                1                1

// Example ( heapify() ): A node changes in a max heap
//      Array { 6, 5, 4, 3, 5, 2 }    is changed to { 1, 5, 4, 3, 5, 2 }  -------->  Compare child nodes, move 5 up
//                  6                               1                                          5
//               /     \                         /     \     changed to max heap             /    \
//              5       4                       5       4  ----------------------->         1      4   
//            /   \    /                      /   \    /                                  /   \   / 
//           3     5  2                      3     5  2                                  3     5 2   


import java.util.Arrays;

public class HeapSort {
  public static void heapSort(int[] arr) {
    if (arr == null || arr.length < 2) return;
    for (int i=0; i<arr.length; i++) {
      heapInsert(arr, i);   // construct max heap from 0 to i each loop
    }
    int heapSize = arr.length;   // heapSize = number of nodes 
    swap(arr, 0, --heapSize);    // decrement heapSize by 1 , swap the root (max value) to the last node
    while (heapSize > 0) {       
      heapify(arr, 0, heapSize); // heapify node 0 to heapSize-1, that makes root has max value again 
      swap(arr, 0, --heapSize);  // decrement heapSize by 1, swap the root (max value) to the last node 
    }
  }
 
  // insert a node at X time complexity is related to tree height (logX)
  // total time complexity = log1+log2+log3+...+log(N-1)+logN ---> O(N)
  public static void heapInsert(int[] arr, int index) {
    // swap when child (leaf node) is greater than parent(sub-root node)
    while (arr[index] > arr[(index-1)/2]) {
      swap(arr, index, (index-1)/2);
      index = (index-1)/2;
    }
  }
  
  // "0 - (heapSize-1)" is max heap
  // Node (index) is changed, the function does max heap from Node index
  public static void heapify(int[] arr, int index, int heapSize) {
    int left = index *2 + 1;   //left child,  left+1 -> right child
    while (left < heapSize) {
      int largest = left + 1 <  heapSize && arr[left+1] > array[left] ?
                    left + 1 : left;
      largest = arr[largest] > arr[index] ? largest : index;
      if (largest == index) {
        break;
      }
      swap(arr, largest, index);
      index = largest;        // Node (index) is changed
      left = index * 2 + 1;   // Start over left child for the new Node 
    }
  }
  
  public static void swap(int[] arr, int i; int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

}

