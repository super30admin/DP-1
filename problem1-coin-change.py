#time - o(n*m) n number of coins and m is target value
#space -- o(n*m)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins == None or len(coins) == 0:
            return 0

        n = len(coins)
        dp = [[0] * (amount + 1)] * (n + 1)
        for i in range(1, amount + 1):
            dp[0][i] = amount + 5  # infinity
        for i in range(1, n + 1):
            for j in range(1, amount + 1):
                # till denomination is grater than amount(j) that we have zero case till that time
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        if dp[n][amount] == amount + 5:
            return -1
        return dp[n][amount]


