"""
A binary heap is a data structure that can be visualized as a complete binary tree, where every level of the tree 
is completely filled except possibly the last level, which is filled from left to right. 
Binary heaps are commonly used to implement priority queues and heap sort algorithms.

In a binary heap, the parent nodes always have a higher (or lower, depending on whether it's a max heap or min heap) 
value than their child nodes. This property is known as the heap property.

There are two types of binary heaps:
   1. Max Heap: In a max heap, the value of each parent node is greater than or equal to the values 
      of its child nodes. Therefore, the maximum element in the heap is always at the root.
   2. Min Heap: In a min heap, the value of each parent node is smaller than or equal to the values 
      of its child nodes. Hence, the minimum element in the heap is always at the root.

Binary heaps can be represented using arrays, where the elements are stored in a level-by-level order. 
The root of the heap is stored at index 0, and for any node at index i, its left child is stored at index 2i+1, 
and its right child is stored at index 2i+2.

The binary heap data structure supports efficient operations, including:
   1. Insertion: To insert an element into the heap, it is added as the last element in the array 
      and then "bubbled up" by comparing it with its parent nodes until the heap property is satisfied.
   2. Deletion: The deletion operation typically removes the root element from the heap. 
      After removal, the last element in the array is moved to the root position, and it is 
      then "bubbled down" by comparing it with its child nodes until the heap property is satisfied.
   3. Peek/Extract: This operation returns the value of the root element without removing it from the heap. 
      It allows accessing the minimum or maximum element efficiently.

Binary heaps provide efficient time complexities for these operations. 
Insertion and deletion have a time complexity of O(log n), where n is the number of elements 
in the heap. Peek/Extract operation has a constant time complexity of O(1).

Binary heaps are widely used in various algorithms and data structures due to their efficient nature, 
especially for priority queue applications where elements need to be accessed in a specific order 
based on their priority.
"""

class BinaryHeap:
    def __init__(self):
        self.heap = []

    def parent(self, index):
        return (index - 1) // 2

    def left_child(self, index):
        return (2 * index) + 1

    def right_child(self, index):
        return (2 * index) + 2

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def insert(self, value):
        self.heap.append(value)
        self.heapify_up(len(self.heap) - 1)

    def delete(self):
        if not self.is_empty():
            self.swap(0, len(self.heap) - 1)
            deleted_value = self.heap.pop()
            self.heapify_down(0)
            return deleted_value

    def heapify_up(self, index):
        while index > 0 and self.heap[index] > self.heap[self.parent(index)]:
            self.swap(index, self.parent(index))
            index = self.parent(index)

    def heapify_down(self, index):
        largest = index
        left = self.left_child(index)
        right = self.right_child(index)

        if left < len(self.heap) and self.heap[left] > self.heap[largest]:
            largest = left

        if right < len(self.heap) and self.heap[right] > self.heap[largest]:
            largest = right

        if largest != index:
            self.swap(index, largest)
            self.heapify_down(largest)

    def is_empty(self):
        return len(self.heap) == 0

    def print_heap(self):
        print(self.heap)
