def linear_search(arr, target):
    """
    Performs linear search on a given list to find the target element.

    Parameters:
    arr (list): The list to be searched.
    target: The element to be found.

    Returns:
    int: The index of the target element if found, or -1 if not found.
    """
    for i in range(len(arr)):
        if arr[i] == target:
            return i  # Element found, return its index
    return -1  # Element not found


# Example usage
my_list = [5, 2, 8, 10, 3, 1]
target_element = 8

result = linear_search(my_list, target_element)
if result != -1:
    print(f"Element {target_element} found at index {result}.")
else:
    print("Element not found.")
