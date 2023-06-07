
# The Fibonacci sequence is a series of numbers in which each number (after the first two) 
# is the sum of the two preceding ones. It starts with 0 and 1, and each subsequent number 
# is obtained by adding the two numbers immediately before it.

# When you run this code with n_terms = 10, it will generate the Fibonacci sequence 
# with 10 terms: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34].

def fibonacci_sequence(n):
    memo = {}  # Dictionary to store previously computed values

    def fib(n):
        if n <= 1:
            return n        
        if n in memo:
            return memo[n]

        memo[n] = fib(n-1) + fib(n-2)  # Memoize the computed value
        return memo[n]

    sequence = [fib(i) for i in range(n)]
    return sequence

# Example usage
n_terms = 10
fib_sequence = fibonacci_sequence(n_terms)
print(fib_sequence)
