#Coin Change
#T.C => O(n * n)
#S.C => O(n)
#Approach => In this approach we are storing a min coins required to reach the amount. Its a pure DP problem. At every coins we are checking what are the combination of previous coins are used 
# to make the min coins used to reach the amount. So as it recurse or iterate we store the min value in the array and return it.  

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        print(dp)
        
        for a in range(1, amount + 1):
            for c in coins:
                if a - c >= 0:
                    dp[a] = min(dp[a], 1 + dp[a - c])
        if dp[amount] != amount + 1:
            return dp[amount]
        else:
            return -1