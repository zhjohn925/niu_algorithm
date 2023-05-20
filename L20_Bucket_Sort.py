def bucket_sort(arr):
    # Create an empty list of buckets
    buckets = []

    # Determine the number of buckets based on the input size
    num_buckets = len(arr)

    # Initialize the buckets
    for _ in range(num_buckets):
        buckets.append([])

    # Place elements into their respective buckets
    for num in arr:
        index = int(num * num_buckets)
        buckets[index].append(num)

    # Sort each bucket individually
    for bucket in buckets:
        insertion_sort(bucket)

    # Concatenate the sorted buckets into the final sorted array
    sorted_arr = []
    for bucket in buckets:
        sorted_arr.extend(bucket)

    return sorted_arr


# Insertion Sort works by dividing the input array into two parts: the sorted portion and the unsorted portion.
# 1. Start with the first element (assume it is already sorted).
# 2. Take the next element from the unsorted portion and insert it into the correct position in the sorted portion.
# 3. Compare the selected element with the elements in the sorted portion, shifting them to the right until 
#    the correct position is found.
# 4. Repeat steps 2 and 3 until all elements in the unsorted portion are processed.
# The insertion sort algorithm has a time complexity of O(n^2) in the worst case, 
# where n is the number of elements in the array. However, it performs well on small lists or 
# partially sorted lists, where it can have a time complexity close to O(n) and exhibit good 
# performance.
def insertion_sort(arr):
    # Perform insertion sort on the given array
    for i in range(1, len(arr)):
                            # sorted array is before i; unsorted array is i and after i   
        card = arr[i]       # pick i   
        j = i - 1           
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]   # push larger than key [i] to the right
            j -= 1
        arr[j + 1] = card   # insert the card 


# Example usage
arr = [0.8, 0.1, 0.5, 0.3, 0.9, 0.6, 0.2, 0.4, 0.7]
sorted_arr = bucket_sort(arr)
print("Sorted array:", sorted_arr)
