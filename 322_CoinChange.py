# time complexity : O(mn)
# space Complexity : O(mn)
# m = number of coins
# n = total amount
class Solution:
    def coinChange(self, coins, amount) -> int:
        m = len(coins)
        n = amount
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
        
        for j in range(1,len(dp[0])):
            dp[0][j] = 99999

        for i in range(1,len(dp)):
            for j in range(1,len(dp[i])):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-(coins[i-1])])
       
        if dp[m][n] >= 99999:
            return -1

        return dp[m][n]

obj = Solution()
print(obj.coinChange([1,2,5],11))

