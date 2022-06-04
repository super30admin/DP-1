class RecursiveSolution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0:
            return 0
        return self.helper(coins, 0, amount, 0)

    def helper(self, coins, idx, amount, currCoins):
        # base
        if amount == 0:
            return currCoins
        if idx >= len(coins) or amount < 0:
            return -1
        # logic
        case1 = self.helper(coins, idx + 1, amount, currCoins)

        case2 = self.helper(coins, idx, amount - coins[idx], currCoins + 1)

        if case1 == -1:
            return case2
        if case2 == -1:
            return case1

        return min(case1, case2)


class DPSolution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if len(coins) == 0:
            return -1
        dp = []
        for i in range(len(coins) + 1):
            dp.append([0] * (amount + 1))

        for i in range(1, len(dp[0])):
            dp[0][i] = amount + 1

        for i in range(1, len(dp)):
            for j in range(len(dp[0])):
                # print(coins[i-1],j)
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        # print(dp)
        return dp[-1][-1] if dp[-1][-1] != amount + 1 else -1