# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution:
    def coinChange(self, coins, amount: int) -> int:
        # null case
        if coins is None or len(coins) == 0: return 0
        dp = [[0 for j in range(amount + 1)] for i in range(len(coins) + 1)]
        # fill in dummy columns
        for j in range(1, len(dp[0])):
            dp[0][j] = amount + 1
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                # denomination greater than amount
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        coins_num = dp[len(coins)][len(dp[0]) - 1]
        print(coins_num)


obj = Solution()
amount = 11
coins = [1, 2, 5]
print(obj.coinChange(coins, amount))
