# Time Complexity : O(n * m) where n is numberCoins and M is the amount
# Space Complexity : O(n) for creating dpArr
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        """ 
        Initial thoughts:
            - prob can solve w/ recursion 
            - knapsack variation?
        Create DP arr and store min number of coins in it.

        """
        if not coins or amount < 0:
            return -1
        
        dp = [float('inf') for i in range(amount+1)]
        dp[0] = 0 
        
        #started dp[0] at 0 
        for i in range(amount+1):
            for j in range(len(coins)):
                if coins[j] <= i:
                    #compute and store min number of coins required in the dp Arr
                    dp[i] = min(dp[i], 1 + dp[i - coins[j]])
        
        if dp[amount] > amount:
            return -1
        else:
            return dp[amount]