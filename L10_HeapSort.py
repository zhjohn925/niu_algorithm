def heapify(arr, n, i):
    """
    Helper function to heapify a subtree rooted at index i
    in the array arr with size n.
    """
    largest = i
    left = 2 * i + 1  # index of the left child
    right = 2 * i + 2  # index of the right child

    # Check if the left child is larger than the root
    # left < n : make sure the left child in the tree
    if left < n and arr[left] > arr[largest]:
        largest = left

    # Check if the right child is larger than the current largest
    # right < n : make sure the right child in the tree
    if right < n and arr[right] > arr[largest]:
        largest = right

    # If the largest element is not the root, swap them
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]

        # Recursively heapify the affected subtree
        heapify(arr, n, largest)


def heap_sort(arr):
    """
    Heap Sort implementation.
    """
    n = len(arr)

    # Build a max heap by repeatedly heapifying each subtree
    # Starting from the last non-leaf node up to the root
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extract elements from the heap one by one
    for i in range(n - 1, 0, -1):
        # Swap the root (maximum element) with the last element
        arr[0], arr[i] = arr[i], arr[0]

        # Heapify the reduced heap (excluding the sorted elements)
        heapify(arr, i, 0)


# Example usage
arr = [12, 11, 13, 5, 6, 7]
heap_sort(arr)
print("Sorted array:", arr)
