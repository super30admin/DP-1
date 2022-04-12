# Time Complexity :O(n * k)
# Space Complexity : O(n * k)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0 or len(coins) == 0:
            return 0

        minCoinsReq = [float('inf')] * (amount+1)
        minCoinsReq[0] = 0

        for amt in range(amount):
            for coin in coins:
                index = coin + amt
                if(index <= amount):
                    minCoinsReq[index] = min(
                        minCoinsReq[index], minCoinsReq[amt] + 1)

        if minCoinsReq[amount] == float('inf'):
            return -1
        return minCoinsReq[amount]
