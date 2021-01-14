"""
We need to compute the min coins reqired at reach stage to make up the target. example in array
 [1,2,3] for target = 6, while iterating over the first element we need 6  - one coins to make up the 
 target. same way at the end for coin 3 to form the target we just need 2 coins the min(dp[j], dp[j-i] + 1) 
 does this computation to find the min coins required.
"""
def coinChange(self, coins, amount):
        dp = [float ('inf')] * (amount + 1)
        dp[0] = 0
        for i in coins:
            for j in range(len(dp)):
                if i <= j:
                    dp[j] = min(dp[j], dp[j-i]+1)
        
        if dp[amount] == float('inf'):
            return -1
        return dp[amount]