# time complexity is o(nm), where n is amount, m is the size of coins
# # Space complexity is o(nm), where n is amount, m is the size of coins
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        print(m,n)
        dp = [[None for i in range(n+1)] for i in range(m+1)]
        dp[0][0] = 0
        for j in range(1,n+1):
            dp[0][j] = 99999
        for i in range(1,m+1):
            for j in range(0,n+1):
                if(j < coins[i-1]):
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        return -1 if dp[m][n] >= 99999 else dp[m][n]
    
    
    