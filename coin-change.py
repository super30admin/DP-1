# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if (coins is None or len(coins)==0):
            return -1
        
        m = amount
        n = len(coins)
        dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

        for i in range(m+1):
            dp[0][i] = amount+1
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j - coins[i-1]]+1)
        
        if(dp[n][m] > amount):
            return -1
        return dp[n][m]


sc = Solution()
coins = [1,2,5] 
amount = 11
print(sc.coinChange(coins, amount))