#Time complexity : O(amount)
#Space complexity : O(amount)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp_size = amount+1
        dp = [dp_size]*(dp_size)
    
        for i in range(0,(dp_size)):
            if i==0:
                dp[0]=0
            else:
                vals = []
                for j in coins:
                    if(i-j>=0):
                
                        dp[i] = min(dp[i],1+dp[i-j])
        if(dp[amount]>amount):
            return -1
        else:
            return dp[amount]

