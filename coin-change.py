# Time Complexity : n be the number of coins and m the amount : O(n * m)
# Space Complexity : O(m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes


# Your code here along with comments explaining your approach

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        def helper(coins, amount, dp=dict()):
            if amount in dp:
                return dp[amount]

            if amount == 0:
                return 0

            if amount < 0:
                return -1

            # to keep track of all the remainder we need to pick the shortest of all
            shortest = -1

            for i in coins:
                remainder = helper(coins, amount - i, dp)
                if remainder != -1:
                    curr = remainder + 1

                    if shortest == -1 or curr < shortest:
                        shortest = curr

            dp[amount] = shortest
            return shortest

        return helper(coins, amount)
