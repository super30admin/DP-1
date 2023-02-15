# Bottom Up DP
# Successfully submitted
# TC = SC = O(amount * len(coins))
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if len(coins) == 0 or coins == None:
            return -1

        m = len(coins)  # rows
        n = amount  # cols
        # adding 1 extra row and col for 0 denomination and 0 amount
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]  # 2D array using list comprehension

        # No number of 0 value coins will ever add up to an amount more than 0. Setting infinity as amount+1
        for k in range(1, n + 1):
            dp[0][k] = amount + 1

        for l in range(1, m + 1):
            for h in range(1, n + 1):
                # zero case just above
                if h < coins[l - 1]:
                    dp[l][h] = dp[l - 1][h]

                # one case
                else:
                    dp[l][h] = min(dp[l - 1][h], 1 + dp[l][h - coins[l - 1]])

        # if no number of coins make up the amount
        if dp[m][n] == amount + 1:
            return -1
        return dp[m][n]