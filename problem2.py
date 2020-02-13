'''
Time Complexity :O(S*n) A is the amount and n is the number of coins
Space Complexity: O(1)
Did this code successfully run on Leetcode : No (Max Recursive depth on large denomination and few edge cases to fix)
Explanation: Create a function and traverse recursively every time we decrease the amount by a denomination and find
all subproblems.
'''


class Solution:

    def coinChange(self, coins: List[int],  amount: int) -> int:
        if coins == None or len(coins) == 0:
            return -1

        m = len(coins)
        n = amount

        dp = [[None] * (n + 1) for i in range(0, m + 1)]

        for i in range(1, n + 1):
            dp[0][i] = 9999

        for i in range(0, m + 1):
            dp[i][0] = 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)

        if dp[m][n] == 9999:
            return -1
        else:
            return dp[m][n]
