## Problem1 (https://leetcode.com/problems/coin-change/)

# Time Complexity : O(coins*amount)
# Space Complexity : O(coins*amount) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        d = [[None for i in range((amount + 1))] for j in range(len(coins) + 1)]
        
        # adding +1 for considering zero, first column initialize to zero
        for i in range(len(coins) + 1):
            d[i][0] = 0
            
        # first row initialize to infinity
        for j in range(1, len(d[0])):
            d[0][j] = 9999
            
        # since 0th row and column are initialized, start the range from 1
        for i in range(1, len(d)):
            for j in range(1, len(d[0])):
                if j < coins[i - 1]:
                    d[i][j] = d[i - 1][j]
                else:
                    #
                    d[i][j] = min(d[i - 1][j], d[i][j - coins[i - 1]] + 1)
        if d[-1][-1] >= 9999:
            return -1
        return d[-1][-1]
        