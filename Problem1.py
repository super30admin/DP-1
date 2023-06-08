# Time Complexity : O(nc) where n is the total amount and c is the number of coins
# Space Complexity : O(n) for the 1d dp array having size `amount`
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  Here we are looking for the minimum number of coins required to make up the target.
#  In order to use DP, at every step, we make a choice of whether to pick the coin
# or skip the coin and move to the next coin.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf') for _ in range(amount+1)]
        dp[0] = 0
        
        for r in range(len(coins)):
            for c in range(coins[r], amount+1):
                dp[c] = min(dp[c], 1 + dp[c - coins[r]], dp[c])
        
        return -1 if dp[amount] == float('inf') else dp[amount]