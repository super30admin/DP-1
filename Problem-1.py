#Time Complexity : O(m*n) where m is amount and n is len(coins)
#Space Complexity : O(m) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #dp state is number of coins to reach that value i
        #lets say there is i=3 dp[i]= min coins to make value 3

        if amount == 0:
           return 0
        dp = [float("inf")]*(amount+1)
        dp[0] = 0
        for i in range(amount+1):
            for c in coins:
                if (i>=c):
                    dp[i] = min(dp[i],dp[i-c]+1)
        return dp[amount] if dp[amount] != float("inf") else -1
       
