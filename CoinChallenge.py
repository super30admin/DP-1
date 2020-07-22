# Time Complexity : O (n*m) where n is the number of coins, m is the range of target value
# Space Complexity : O (n*m)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        numberOfCoins = len(coins)

        # we create a dynamic memory matrix, where in each execution we will refer the previous values
        dpMatrix = [[None for j in range(amount + 1)] for i in range(numberOfCoins + 1)]

        # the number of ways of getting 0 value from 0 coins is 0
        dpMatrix[0][0] = 0

        # the number of ways of getting 0 value from all other coins individually will be 0
        for i in range(1, numberOfCoins + 1):
            dpMatrix[i][0] = 0

        # the number of ways of getting range(1, len(target)) using 0 coins will be infinite.
        for j in range(1, amount + 1):
            dpMatrix[0][j] = 999999

        for i in range(1, numberOfCoins + 1):

            for j in range(1, amount + 1):

                # if current value is less than or equal to the previous coin then optimal
                # solution will be using the previous coin ways of getting the value.
                if coins[i - 1] > j:

                    dpMatrix[i][j] = dpMatrix[i - 1][j]

                else:

                    # else we compare the previous coin optimal way to reeach the target and current coin optimal way to
                    # reach  (target - current coin) value plus adding 1 value of current coin. And we use the min
                    # optimal ways

                    dpMatrix[i][j] = min(dpMatrix[i - 1][j], dpMatrix[i][j - coins[i - 1]] + 1)

        if dpMatrix[-1][-1] < 999999:
            return dpMatrix[-1][-1]
        else:
            return -1
