# Time Complexity : O(n*T) where n is the number of coins and T is the target amount 
# Space Complexity : O(n*T) where n is the number of coins and T is the target amount
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : Followed approach from the class 
#coin change
class Solution:
    def coinChange(self, coins, amount):
        dp = [float("inf") for i in range(amount+1)]
        dp[0] = 0  # Base case when amount is 0 then coins needed is also 0
        for i in range(1, amount+1):
            for j in range(len(coins)):
                if (coins[j] <= i):
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)
        
        #print(dp)
        return -1 if dp[-1] == float("inf") else dp[-1]

