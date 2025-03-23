class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = [[float('inf') for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for i in range(len(coins) + 1):
            for j in range(amount + 1):
                if j == 0:
                    dp[i][j] = 0

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                current_coin_value = coins[i - 1]
                amount = j

                if coins[i - 1] <= j:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - current_coin_value])
                else:
                    dp[i][j] = dp[i - 1][j]

        answer = -1 if dp[len(coins)][amount] == float('inf') else dp[len(coins)][amount]

        return answer









