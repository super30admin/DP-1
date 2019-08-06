"""
time: O(n^2)
space:O(n)
Leet: accepted at 72.66%
Problems: No problem. Understood the solution.
"""

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        #create memo
        memo = [amount+1] * (amount+1)
        memo[0] = 0

        #maintain the least amount of coins
        #needed for each value upto amount
        for value in range(len(memo)):
            for coin in coins:
                if coin <= value:
                    memo[value] = min(memo[value],memo[value-coin]+1)
        if memo[amount] == amount + 1:
            return -1
        else:
            return memo[amount]
