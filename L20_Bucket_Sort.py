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


def insertion_sort(arr):
    # Perform insertion sort on the given array
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key


# Example usage
arr = [0.8, 0.1, 0.5, 0.3, 0.9, 0.6, 0.2, 0.4, 0.7]
sorted_arr = bucket_sort(arr)
print("Sorted array:", sorted_arr)
