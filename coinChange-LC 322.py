# Time Complexity = O(m *n), m = number of rows (index of coins array), n = amount 
# Space Complexity = O(m * n),  Using 2D matrix to store answers/computations.

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        if len(coins) == 0 or coins is None:
            return -1
        
        
        m = len(coins)      # for Rows
        n = amount          # for Cols
        dp = [[0] * (n + 1)] * (m + 1)      # +1 since Tabulating for coin value 0 and amount 0 too
        
        for j in range(n + 1):     # j denotes cols
            dp[0][j] = amount + 1       # no sub array combination should be greater than amount + 1 coins
        
        # Initialising for the amount = 0
        for i in range(m + 1):
            dp[i][0] = 0
        
        # Iterating for rows and cols
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # If amount >= the value of coin, we extract the min between 'not choosing that index element' and 'choosing that index element'
                if j >= coins[i-1]:
                    dp[i][j] = min(dp[i-1][j], 1 + (dp[i][j - coins[i-1]]))
                # If amount < value of coin at that index, copy from the above row
                else:
                    dp[i][j] = dp[i-1][j]
                    
        # If the value at last element is == amount + 1, the answer would be wrong, hence not possible 
        if dp[m][n] == amount + 1:
            return -1 
        
        # Last element of the matrix gives the answer
        return dp[m][n]
        