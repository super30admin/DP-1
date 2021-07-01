class Solution:
    def coinChange(self, coins, amount) :

        rows = len(coins) + 1
        columns = amount + 1

        dp = [[0 for i in range(columns)] for j in range(rows)]

        dp[0][0] = 0

        for j in range(1, columns):
            dp[0][j] = 1 + amount

        for i in range(1, rows):
            dp[i][0] = 0

        for i in range(1, rows):

            for j in range(1, columns):

                if j < coins[i - 1]:
                    # zero case
                    dp[i][j] = dp[i - 1][j]
                else:
                    # zero and one case of tree
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

                result = dp[rows - 1][columns - 1]

        if result > amount:
            return -1

        return result

sol=Solution()
coinarr=[1,2,5]
print (sol.coinChange(coinarr,11))