class Solution(object):
    def coinChange(self, coins, amount):
        """
        Recursion
        Time complexity: O (2^n)
        Space complexity: O(n)
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        def helper(coins, idx, amount, coinsUsed):
            # Base case: If amount becomes zero, return the number of coins used
            if amount == 0:
                return coinsUsed
            # Base case: If amount becomes negative or we have exhausted all coins, return -1
            if amount < 0 or idx == len(coins):
                return -1

            # Recursive calls
            # Choose the current coin and subtract its value from the amount
            case1 = helper(coins, idx, amount - coins[idx], coinsUsed + 1)
            # Don't choose the current coin and move to the next coin
            case2 = helper(coins, idx + 1, amount, coinsUsed)

            # Find the minimum number of coins needed
            if case1 == -1:
                return case2
            if case2 == -1:
                return case1
            return min(case1, case2)

        # Call the helper
        return helper(coins, 0, amount, 0)
