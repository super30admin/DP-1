# 322. Coin Change
# fewest number of coins that you need to make up that amount.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount ==0: return 0 
        dp = [ float(inf)] * (amount+1)
        dp[0] =0 
        
        for c in coins:
            if c<amount+1 : dp[c] = 1 
        
        for i in range(amount+1):
            for c in coins:
                if i>c:dp[i]= min(dp[i], dp[i-c] + 1)
                    
                    
        if dp[-1]==float(inf): 
            return -1 
        else: return dp[-1]