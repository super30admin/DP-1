## Problem1 (https://leetcode.com/problems/coin-change/)


# Brute Force

'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        result = self.getCoins(0, amount, coins)
        if result == 1e9:
            return -1
        return result

    def getCoins(self, index, amount, coins):
        if index >= len(coins) or amount < 0:
            return 1e9
        if amount == 0:
            return 0
        not_choose = self.getCoins(index + 1, amount, coins)
        choose = 1 + self.getCoins(index, amount - coins[index], coins)
        return min(not_choose, choose)

'''

# DP using memoization (Top Down)
'''
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        memo = [[-1] * (amount + 1) for _ in range(n)]
        result = self.getCoins(0, amount, coins, memo)
        if result == 1e9:
            return -1
        return result

    def getCoins(self, index, amount, coins, memo):
        if amount == 0:
            return 0
        if index >= len(coins) or amount < 0:
            return 1e9
        if memo[index][amount] != -1:
            return memo[index][amount]
        not_choose = self.getCoins(index + 1, amount, coins, memo)
        choose = 1 + self.getCoins(index, amount - coins[index], coins, memo)
        memo[index][amount] = min(not_choose, choose)
        return memo[index][amount]

'''

# Tabulation

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        INF = int(1e9)

        memo = [[0] * (amount + 1) for _ in range(n + 1)]

        for target in range(1, amount + 1):
            memo[n][target] = INF

        for index in range(n - 1, -1, -1):
            for target in range(amount + 1):
                not_choose = memo[index + 1][target]

                choose = INF
                if target >= coins[index]:
                    choose = 1 + memo[index][target - coins[index]]

                memo[index][target] = min(not_choose, choose)

        result = memo[0][amount]
        return -1 if result == INF else result
