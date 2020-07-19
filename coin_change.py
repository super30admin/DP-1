#Tume complexity: O(n*T): where n: # of coins, T: target
#Space complexity: O(n*T): where n: # of coins, T: target
#Worked on leetcode
#This algorithm uses dynamic programming, by first calculating the optimal value when
# a coin is not chosen, versus when a coin is chosen, for each coin iteratively.
# It then takes the maximum value of when all coins are present, and we decide whether
# or not to choose it.

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = [[0 for _ in range(amount + 1)] for _ in range(len(coins) + 1)]

        for i in range(len(coins)):
            dp[i][0] = 0  # some max value

        for m in range(1, amount + 1):
            dp[0][m] = 9999  # some max value

        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        if dp[len(coins)][amount] == 9999:
            return -1
        else:
            return dp[len(coins)][amount]

