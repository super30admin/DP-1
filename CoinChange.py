class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        rows = len(coins)
        cols = amount
        
        dp = [[0 for _ in range(cols + 1)] for _ in range(rows+1) ]
        
        
        for j in range(1, amount + 1):
            dp[0][j] = amount + 1
        # Putting the maximum value for the first row
        
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                
                if j < coins[i - 1]: # if the amount is less then the value of coins directly put the value of the row above it
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1+ dp[i][j - coins[i - 1]]) # Else take the minimum of the value row above and the value which is left to the current coin amount
                    
        if dp[rows][cols] == amount + 1:
            return -1
        return dp[rows][cols]
    
    # Time Complexity: O(M*N) where M is rows and N is columns
    # Space Complexity: O(M*N)