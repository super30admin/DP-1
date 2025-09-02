
# Using bottom up with tabulation(optimized space using 1D array)
# Time complexity: O(m*n) where m is number of coins and n is amount
# Space complexity: O(n)
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        dp = [amount + 1] * (n + 1)  #amount+1 is infinity here
        dp[0] = 0
        for i in range(1, m+1):
            for j in range(1, n+1):
                if j < coins[i-1]:
                    dp[j] = dp[j] 
                else:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i-1]]) 
        return -1 if dp[n] == amount+1 else dp[n]
