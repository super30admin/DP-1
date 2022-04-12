from typing import List

"""
Time complexity is O(m*n), where m is no of coins and n is the target value
 Space complexity is O(m*n) too.
"""


def helper(coins: List[int], amount: int, coins_used: int) -> int:
    # stopping conditions
    if amount < 0:
        return -1

    if len(coins) == 0:
        return -1

    if amount == 0:
        return coins_used

    dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

    for col in range(1, amount+1):
        dp[0][col] = amount+1

    for row in range(1, len(coins)+1):
        for col in range(1, amount+1):
            if col<coins[row-1]:
                dp[row][col] = dp[row-1][col]
            dp[row][col] = min(dp[row-1][col], dp[row][col-coins[row-1]]+1)

    if dp[len(coins)][amount] == amount+1:
        return -1
    else:
        return dp[len(coins)][amount]


class Solution:
    def coinChange(coins: List[int], amount: int) -> int:

        # stopping conditions
        if len(coins) == 0:
            return 0

        dp = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for col in range(1, amount + 1):
            dp[0][col] = amount + 1

        for row in range(1, len(coins) + 1):
            for col in range(1, amount + 1):
                if col < coins[row - 1]:
                    dp[row][col] = dp[row - 1][col]
                else:
                    dp[row][col] = min(dp[row - 1][col], dp[row][col - coins[row - 1]] + 1)

        if dp[len(coins)][amount] == amount + 1:
            return -1
        else:
            return dp[len(coins)][amount]

    print(coinChange([2], 3))
