# Time Complexity : O(amount*len(coins)) O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, had to lookup solution several times.


# DP approch - Bottom up
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[amount+1]*(amount+1)
        dp[0]=0
        
        for a in range(1,amount+1):
            for c in coins:
                if (a-c) >= 0:
                    dp[a]=min(dp[a],1+dp[a-c])
        if dp[amount] == amount+1:
            return -1
      
        return dp[amount]