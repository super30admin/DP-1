class MinCoins(object):
    '''
    Solution:
    1. Problem can be solved using recursion and has overlapping subproblems and so use dynamic programming. Recursive
        step would be based on whether the coin is chosen or not.
    2. If coin is not chosen, the value of the cell would be previous row's extract, otherwise it would be minimum of
        [previous row (same column) value, 1 + column minus coinValue (same row)]
    3. Return the last cell's value if less than infinity (amount + 1 here) else -1.
    '''
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """

        # O(numCoins * Amount) Time Complexity | O(numCoins * Amount) Space Complexity
        dpTable = [[None for i in range(amount + 1)] for i in range(len(coins) + 1)]
        maxValue = amount + 1

        for i in range(len(coins) + 1):
            dpTable[i][0] = 0

        for j in range(1, amount + 1):
            dpTable[0][j] = maxValue

        for rowCoin in range(1, len(coins) + 1):
            for colAmount in range(1, amount + 1):
                if colAmount < coins[rowCoin - 1]:
                    dpTable[rowCoin][colAmount] = dpTable[rowCoin - 1][colAmount]
                else:
                    dpTable[rowCoin][colAmount] = min(dpTable[rowCoin - 1][colAmount],
                                                      1 + dpTable[rowCoin][colAmount - coins[rowCoin - 1]])

        minCoins = dpTable[len(coins)][amount]
        minCoins = minCoins if minCoins < maxValue else -1

        return minCoins


