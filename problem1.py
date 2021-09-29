# Time Complexity : O(mn)  m=number of coins, n= amount
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount+1] * (amount +1)
        dp[0] = 0 #initializing dp to 0
        
        for i in range (1, amount+1):
            for j in coins:
                if( i - j>=0):
                    dp[i] = min(dp[i], 1+dp[i-j])
        if dp[amount] != amount+1:
                return dp[amount]
        else:
                return -1
