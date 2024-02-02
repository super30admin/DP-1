# Time complexity: o(mn)  n is the number of coins and m is the amount
# space complexity: o(mn) n is the number of coins and m is the amount

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        # Commented one is the exhaustive approach
        # re = self.helper(coins, amount, 0, 0)
        # if re == 999999999999:
        #     return -1
        # return re

        # We take amount + 1 because we want amount from 0 to amount so cols are amount + 1
        amountCol = amount + 1
        # We take len(coins) + 1 because we want to add dummy coin 0 in the array
        coinsRow = len(coins) + 1

        matrix = [None] * coinsRow
        # Here I just initilize for zero amount we need 0 coin
        matrix[0] = [0]
        # Here I am adding elements for coin 0
        for col in range(1, amountCol):
            matrix[0].append(999999)

        # Now I am start filling the matrix with coin used with respect to amount
        for i in range(1, coinsRow):
            matrix[i] = []
            for j in range(0, amountCol):
                if j < coins[i - 1]:
                    matrix[i].append(matrix[i - 1][j])
                else:
                    matrix[i].append(
                        min(matrix[i - 1][j], 1 + matrix[i][j - coins[i-1]]))

        if matrix[-1][-1] == 999999:
            return -1
        return matrix[-1][-1]

    # def helper(self, coins, amount, index , coinsUsed):
    #     # Base case
    #     if index == len(coins) or amount < 0:
    #         return 999999999999
    #     if amount == 0:
    #         return coinsUsed
    #     # Coin choosen
    #     case1 = self.helper(coins, amount - coins[index], index, coinsUsed + 1)

    #     #Coin do not choosen
    #     case2 = self.helper(coins, amount, index + 1, coinsUsed)

    #     return min(case1, case2)
