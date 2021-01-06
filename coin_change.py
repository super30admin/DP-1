# Time Complexity : O(S∗n). where S is the amount, n is denomination count
# Space Complexity : O(S), where SS is the amount to change We use extra space for the memoization table.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0
        
        for coin in coins:
            for i in range(coin , amount + 1):
                dp[i] = min(dp[i- coin] + 1, dp[i])
                
        if dp[amount] == float("inf"):
            return -1
        return dp[amount]
