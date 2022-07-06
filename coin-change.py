"""
Runtime Complexity: O(m*n) - Because we have 'm' rows of coins and 'n' columns of amount.
Space Complexity: O(m*n) - because we created 2D dp array to compute our solution.
Yes, the code worked on leetcode.
The idea behind the algorithm is to create a dp array which computes the minimum number of coins used. If amount/j is lesser than the i-1, then we just update j with it else we update the minimum of both cases."""


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins)==0:
            return -1
        m = len(coins)
        n = amount
        dp = [[float('inf') for i in range(n+1)] for i in range(m+1)]
        
        
        for i in range(1,m+1):
            dp[i][0] = 0
        
        
        for i in range(m+1):
            for j in range(n+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
                                   
        return dp[i][j] if dp[i][j]!=float('inf') else -1
            
        