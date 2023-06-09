# The Knapsack Problem involves selecting a subset of items from a given set, each with its own value and weight, 
# in a way that maximizes the total value while keeping the total weight within a given limit 
# (the capacity of the knapsack).
#
# Given:
#    A set of items, each with a value and a weight.
#    A maximum weight or capacity for the knapsack.
# Find:
#    The most valuable combination of items that can be included in the knapsack, without exceeding its weight capacity.


# -------------------------------------------------------------------------------------------------------
# Method 1 ----------------------------------------------------------------------------------------------
# -------------------------------------------------------------------------------------------------------

def knapsack_dynamic_programming(weights, values, capacity):
    ''' The function starts by initializing a 2D table dp with dimensions (n+1) x (capacity+1), 
        where n is the number of items. Each element in the table dp[i][w] represents the maximum value 
        that can be achieved using the first i items and a knapsack capacity of w.'''
    
    n = len(weights)  # Number of items    
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]  # Create a 2D table to store maximum values

    for i in range(1, n + 1):  # Iterate over items
        for w in range(1, capacity + 1):  # Iterate over capacities
            # w is current capacity                              
            if weights[i - 1] <= w:  # If the current item can be included within the current capacity
                # We need maximum value, so
                # Compare the value of including the current item vs excluding the current item
                dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
            else:
                # If the current item cannot be included within the current capacity, exclude it
                dp[i][w] = dp[i - 1][w]
    print(dp)            

    return dp[n][capacity]  # Return the maximum value for the given capacity

# Example usage
weights = [2, 3, 4, 5]  # List of item weights
values = [3, 4, 5, 6]  # List of item values
capacity = 8  # Maximum capacity of the knapsack

max_value = knapsack_dynamic_programming(weights, values, capacity)  # Solve the Knapsack Problem
print("Maximum value:", max_value)  # Print the maximum value


# -------------------------------------------------------------------------------------------------------
# Method 2 ----------------------------------------------------------------------------------------------
# -------------------------------------------------------------------------------------------------------

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
