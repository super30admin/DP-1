#Time Complexity : O(mn)
#Space Complexity : O(m) where m is the amount
#Did this code successfully run on Leetcode : Yes

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp=[9999999999] * (amount+1)
        dp[0]=0
        
        for coin in coins:
            for i in range(coin, amount+1):
                if i-coin>=0:
                    dp[i]=min(dp[i], dp[i-coin]+1)
        
        return -1 if dp[-1]==9999999999 else dp[-1]
              