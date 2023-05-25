# Interpolation search can be particularly useful in scenarios where the data being searched is uniformly 
# distributed and has a large range.
# For example:
# Large Data Sets: If you have a large data set and the elements are uniformly distributed, interpolation search 
# can provide faster search times compared to binary search. This is because interpolation search dynamically 
# adjusts the search range based on the estimated position of the target element, potentially reducing the number 
# of iterations required.

def interpolation_search(arr, target):
    """
    Performs interpolation search on a given sorted list to find the target element.

    Parameters:
    arr (list): The sorted list to be searched.
    target: The element to be found.

    Returns:
    int: The index of the target element if found, or -1 if not found.
    """
    low = 0
    high = len(arr) - 1

    while low <= high and arr[low] <= target <= arr[high]:
        if low == high:
            if arr[low] == target:
                return low
            return -1

        pos = low + ((target - arr[low]) * (high - low)) // (arr[high] - arr[low])

        if arr[pos] == target:
            return pos
        elif arr[pos] < target:
            low = pos + 1
        else:
            high = pos - 1

    return -1  # Element not found


# Example usage
my_list = [1, 3, 5, 7, 9, 11]
target_element = 7

result = interpolation_search(my_list, target_element)
if result != -1:
    print(f"Element {target_element} found at index {result}.")
else:
    print("Element not found.")
