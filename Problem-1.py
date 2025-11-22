# Time Complexity :O(m*n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
#I created a DP array where each index represents the minimum coins needed to form that amount.
# For every amount, I loop through all coins and update the value by checking the best possible previous state.
# In the end, if the value is still MAX_VALUE, it means the amount can't be formed, otherwise I return the computed minimum.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0
        if amount < 0:
            return -1
        for i in range(1,amount+1):
            for j in range(len(coins)):
                if i >= coins[j]:
                    dp[i] = min(dp[i],1+dp[i-coins[j]])
        if dp[amount] == float("inf"):
            return -1
        else:
            return dp[amount]