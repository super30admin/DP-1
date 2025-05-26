"""
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

## Problem1 (https://leetcode.com/problems/coin-change/)

"""

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Create a DP array where dp[i] will hold the minimum number of coins to make amount i
        # Initialize with amount+1, which acts like "infinity" since it's the worst case (won't happen)
        dp = [amount + 1] * (amount + 1)
        
        # Base case: to make amount 0, we need 0 coins
        dp[0] = 0

        # Fill the dp array from 1 to amount
        for i in range(1, amount + 1):
            for coin in coins:
                # If the coin value is less than or equal to current amount i
                if coin <= i:
                    # Choose the minimum coins needed by including this coin
                    dp[i] = min(dp[i], dp[i - coin] + 1)

        # If dp[amount] was never updated, return -1 (no solution)
        return dp[amount] if dp[amount] != amount + 1 else -1
