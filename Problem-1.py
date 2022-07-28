# Coin Change
'''
Leetcode all test cases passed: Yes
Solution:
    coinChange(self, coins, amount):
        t is the target amount + 1
        n is the number of coins
        Space Complexity: O(t)   
        Time Complexity: O(t*n)
'''

class Solution:
    def coinChange(self, coins, amount):
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0
        
        for idx in range(len(dp)):
            for coin in coins:
                if coin <= amount:
                    dp[idx] = min(dp[idx - coin] + 1,dp[idx]) 
        return -1 if dp[-1] == float("inf") else dp[-1] 
