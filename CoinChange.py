"""
    Problem Statement: Coin Change Problem.

    Time complexity: O(m * n)
    
    Space complexity: O(m * n)

    Accepted on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/coin-change 
"""

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[ 0 for col in range(amount + 1)] for row in range(len(coins) + 1)]
        n = len(coins)

        for i in range(1, amount + 1):
            dp[0][i] = amount + 1
        
        for i in range(1, n + 1):
            for j in range(1, amount+1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)
        
        if dp[n][amount] == amount + 1:
            return -1
        
        return dp[n][amount]


if __name__ == "__main__":
    sol = Solution()
    coins, amount = [1, 2, 5], 11
    ret = sol.coinChange(coins, amount)
    assert ret == 3
