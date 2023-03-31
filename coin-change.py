#TC: O(m * n)
#SC: O(m * n)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = []
        for i in range(len(coins)):
            dp.append([0] * (amount + 1))
            dp[i][0] = 0


        for i in range(len(dp)):
            for j in range(1,amount + 1):
                if i == 0:
                    dp[i][j] = amount + 1
                    if j - coins[i] >= 0:
                        dp[i][j] = min(dp[i][j],1 + dp[i][j-coins[i]])
                else:
                    dp[i][j] = dp[i-1][j]
                    if j - coins[i] >= 0:
                        dp[i][j] = min(dp[i][j],1 + dp[i][j-coins[i]])

        return dp[len(coins)-1][amount] if dp[len(coins)-1][amount] < amount + 1 else -1
