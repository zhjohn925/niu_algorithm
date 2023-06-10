# We create a 2D table dp of size (m+1) x (n+1), where m is the length of s1 and n is the length of s2. 
# Each element dp[i][j] in the table represents the length of the longest common subsequence for the 
# substrings s1[0:i] and s2[0:j].

def longest_common_subsequence(s1, s2):
    m = len(s1)  # Length of string s1
    n = len(s2)  # Length of string s2

    # Create a table to store the lengths of LCS for subproblems
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    # Fill the table using bottom-up dynamic programming
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i - 1] == s2[j - 1]:
                # If the characters at current indices match, increment LCS length by 1
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                # If the characters at current indices do not match, take the maximum LCS length from the previous subproblems
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    # Retrieve the LCS from the table
    lcs_length = dp[m][n]  # Length of the LCS
    lcs = [''] * lcs_length  # List to store the characters of the LCS
    i, j = m, n  # Start from the bottom-right cell of the table
    while i > 0 and j > 0:
        if s1[i - 1] == s2[j - 1]:
            # If the characters at current indices match, add the character to the LCS and move diagonally up-left
            lcs[lcs_length - 1] = s1[i - 1]
            i -= 1
            j -= 1
            lcs_length -= 1
        elif dp[i - 1][j] > dp[i][j - 1]:
            # If the LCS length from the previous row is greater, move up
            i -= 1
        else:
            # If the LCS length from the previous column is greater, move left
            j -= 1

    return ''.join(lcs)  # Return the LCS as a string

# Example usage
s1 = "AGGTAB"
s2 = "GXTXAYB"

lcs = longest_common_subsequence(s1, s2)
print("Longest Common Subsequence:", lcs)
