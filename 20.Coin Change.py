class Solution:
    def coinChange(self, coins, amount: int) -> int:
        if coins is None or len(coins) == 0:
            return 0

        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        # print(dp)
        for x in range(1, amount + 1):
            for y in coins:
                if x - y >= 0:
                    dp[x] = min(dp[x], 1 + dp[x - y])
        return dp[amount] if dp[amount] != amount + 1 else -1

        # for x in range(len(dp)):
        #     for y in range(len(dp[0])):
        #         if y < coins[x - 1]:
        #             dp[x][y] = dp[x - 1][y]
        #             print(dp[x][y], 'that')
        #         else:
        #             dp[x][y] = min(dp[x - 1][y], 1 + dp[x][y - coins[x - 1]])
        #             print(dp[x][y], 'This')
        #
        # if dp[len(dp) - 1][len(dp[0]) - 1] > amount:
        #     return -1  # ,print(range(len(dp[0])))

    # return dp[len(dp) - 1][len(dp[0] - 1)]


obj = Solution()
print(obj.coinChange([1, 2, 5], 11))
