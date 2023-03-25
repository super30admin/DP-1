# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""We fill the first row with amount+1 and the first column with 0. We then iterate through the array 
and if the amount is less than the coin value we take the value from the previous row. If the amount 
is greater than the coin value we take the minimum of the previous row and 1 + the value from the 
same row and the amount - coin value. If the value at the last row and last column is amount+1 we 
return -1 else we return the value at the last row and last column."""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1

        n = amount
        m = len(coins)

        dp = [[0] * (n+1)] * (m + 1)
        for i in range(1, n+1):
            dp[0][i] = amount + 1

        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j-coins[i-1]])

        if dp[m][n] == amount + 1:
            return -1
        return dp[m][n]