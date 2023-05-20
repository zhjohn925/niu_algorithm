# Radix Sort is a non-comparative sorting algorithm that sorts elements based on their individual digits or characters. 
# It works by distributing the elements into a set of buckets according to their place value (starting from the least 
# significant digit) and then collecting them back in order.
# -----------------------------------
# Radix Sort has a time complexity of O(d * (n + k)), where d is the number of digits, 
# n is the number of elements in the input array, and k is the range of values for each digit 
# (usually 10 for decimal integers). It is an efficient sorting algorithm when the number of

# Here's a step-by-step explanation of the Radix Sort algorithm:
#
#   1. Determine the maximum number of digits (or characters) among the elements in the input array. 
#      This will be the number of iterations needed for the sorting process.
#   2. Starting from the least significant digit (or character), perform a stable sort (e.g., counting 
#      sort or bucket sort) on the input array based on that digit. 
#      After this step, the elements are partially sorted according to that digit.
#   3. Repeat step 2 for the remaining digits, moving from the least significant to the most significant digit. 
#      Each iteration further refines the sorting order.
#   4. After sorting based on the most significant digit, the elements are in the correct order.


def counting_sort(arr, place):
    n = len(arr)
    count = [0] * 10  # Create a count array to store the frequency of each digit
    output = [0] * n  # Create an output array to store the sorted elements
    
    # Count the frequency of digits at the given place
    for i in range(n):
        index = arr[i] // place
        count[index % 10] += 1
                                                  # count[0]  ----    
    # Calculate the cumulative count              # count[1]  --------     
    for i in range(1, 10):                        # count[2]  -------------- 
        count[i] += count[i - 1]                  # ::::::   
                                                  # count[9]  --------------------------------------------------
    # Build the output array in a stable manner
    i = n - 1
    while i >= 0:
        index = arr[i] // place
        output[count[index % 10] - 1] = arr[i]
        count[index % 10] -= 1
        i -= 1

    # Copy the sorted elements back to the original array
    for i in range(n):
        arr[i] = output[i]
    # print(arr)    
    # [170, 90, 802, 2, 24, 45, 75, 66]
    # [802, 2, 24, 45, 66, 170, 75, 90]
    # [2, 24, 45, 66, 75, 90, 170, 802]

        

def radix_sort(arr):
    # Find the maximum element to determine the number of digits
    max_value = max(arr)

    # Perform counting sort for each digit place
    place = 1
    while max_value // place > 0:
        counting_sort(arr, place)
        place *= 10


# Example usage
arr = [170, 45, 75, 90, 802, 24, 2, 66]
radix_sort(arr)
print("Sorted array:", arr)


