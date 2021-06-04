# Time Complexity: O(n2)
# Space Complexity: O(n)

class Solution(object):
    def coinChange(self, coins, amount):
        # Update the first dummy row with amount + 1
        dp = [[amount + 1] * (amount + 1)] * (len(coins) + 1)

        # upadte first column with all zeros
        for i in range(len(coins) + 1):
            dp[i][0] = 0
        # Iterate over the matrix to fill the number of coins needed for getting the target amount
        for i in range(1, len(dp)):
            for j in range(1, amount + 1):
                # Until the current column index is less than current coin assign the previous row value to current row
                if j < coins[i - 1]:
                    dp[i][j] = dp[i - 1][j]
                # If not then we will take minimum between previous row value
                # and value in current row with index as current index - coins value at current row index
                else:
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])
        #  If value in the last block of matrix is greater than target
        #  amount then return -1 as we cant form required amount with coins we have
        if dp[len(dp) - 1][amount] > amount:
            return -1
        #  else return that value in last block of matrix
        else:
            return dp[len(coins)][amount]

        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
