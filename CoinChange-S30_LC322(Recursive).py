# Recursive/Exhaustive approach
# Exponential Time Complexity (TLE)
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if len(coins) == 0 or coins == None:
            return -1

        return self.helper(coins, amount, 0, 0)

    def helper(self, coins, amount, coinsUsed, index):
        # base
        print("before everything")
        print(coinsUsed, index)
        if (index == len(coins) or amount < 0):
            return -1

        if amount == 0:
            return coinsUsed

        # logic
        # do not choose coin or zero case
        print("before case0")
        print(coinsUsed, index)
        case0 = self.helper(coins, amount, coinsUsed, index + 1)

        # choose coin or one case
        print("before case 1")
        print(coinsUsed, index)
        case1 = self.helper(coins, amount - coins[index], coinsUsed + 1, index)

        print("after case 1")
        print(coinsUsed, index)

        if case0 == -1:
            return case1
        if case1 == -1:
            return case0

        print("before soln")
        print(coinsUsed, index)
        return min(case0, case1)