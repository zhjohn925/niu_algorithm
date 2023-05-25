def binary_search(arr, target):
    """
    Performs binary search on a given sorted list to find the target element.

    Parameters:
    arr (list): The sorted list to be searched.
    target: The element to be found.

    Returns:
    int: The index of the target element if found, or -1 if not found.
    """
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            return mid  # Element found, return its index
        elif arr[mid] < target:
            left = mid + 1  # Search the right half
        else:
            right = mid - 1  # Search the left half

    return -1  # Element not found


# Example usage
my_list = [1, 3, 5, 7, 9, 11]
target_element = 7

result = binary_search(my_list, target_element)
if result != -1:
    print(f"Element {target_element} found at index {result}.")
else:
    print("Element not found.")
