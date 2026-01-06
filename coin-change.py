''' Time Complexity : O(m * n) 
    Space Complexity : O(m * n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach : calculating min no of coins required at each amount
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        dp = [[amount+1 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0] = 0 
        for i in range(1,len(coins)+1):
            for j in range(1,(amount+1)):
                if coins[i-1] > j:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)
        if dp[i][j] == (amount+1):
            return -1
        else:
            return dp[i][j]