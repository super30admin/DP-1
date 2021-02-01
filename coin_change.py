#Tume complexity: O(n*T): where n: # of coins, T: target
#Space complexity: O(n*T): where n: # of coins, T: target
#Worked on leetcode
#This algorithm uses dynamic programming, by first calculating the optimal value when
# a coin is not chosen, versus when a coin is chosen, for each coin iteratively.
# It then takes the maximum value of when all coins are present, and we decide whether
# or not to choose it.

import numpy as np
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = np.zeros((len(coins)+1, amount+1))
        dp[0][1:] = 99999

        for row in range(1, len(coins)+1):
            for col in range(1, amount+1):

                if col < coins[row-1]:
                    dp[row][col] = dp[row-1][col]
                else:
                    dp[row][col] = min(dp[row-1][col], 1+dp[row][col-(coins[row-1])])


        result = int(dp[len(coins)][amount])
        print(dp)
        if result >= 99999: return -1
        else: return result
