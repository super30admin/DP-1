""" Explanation: We iterate through each coin denomination, and for each coin, we update the dp array for amounts from the current 
    coin value to the target amount.
    Time Complexcity: O(coins*amount)
    Space Complexcity: O(amount)
"""


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        result = [amount + 1] *(amount + 1)
        result[0] = 0

        for i in range(amount+1):
            for c in coins:
                if i-c>= 0:
                    result[i] = min(result[i] , 1+result[i-c])

        return result[amount] if result[amount] != amount + 1 else -1
        