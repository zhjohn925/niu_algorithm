# The Knapsack Problem involves selecting a subset of items from a given set, each with its own value and weight, 
# in a way that maximizes the total value while keeping the total weight within a given limit 
# (the capacity of the knapsack).
#
# Given:
#    A set of items, each with a value and a weight.
#    A maximum weight or capacity for the knapsack.
# Find:
#    The most valuable combination of items that can be included in the knapsack, without exceeding its weight capacity.

def knapsack_recursive(weights, values, capacity, n):
    # Base case: if either capacity or the number of items becomes 0, return 0
    if capacity == 0 or n == 0:
        return 0

    # If the weight of the nth item is more than the current capacity, exclude it
    if weights[n - 1] > capacity:
        return knapsack_recursive(weights, values, capacity, n - 1)

    # Return the maximum of two cases:
    # 1. Including the nth item
    # 2. Excluding the nth item
    else:
        include = values[n - 1] + knapsack_recursive(weights, values, capacity - weights[n - 1], n - 1)
        exclude = knapsack_recursive(weights, values, capacity, n - 1)
        return max(include, exclude)

# Example usage
weights = [2, 3, 4, 5]
values = [3, 4, 5, 6]
capacity = 8
n = len(weights)

max_value = knapsack_recursive(weights, values, capacity, n)
print("Maximum value:", max_value)
