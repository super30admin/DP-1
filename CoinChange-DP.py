"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0:
            return -1
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        # Running through the list and changing 
        # modifying the value to the min amount in the dp table
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)
        if dp[amount] != float('inf'):
            return dp[amount]
        else:
            return -1