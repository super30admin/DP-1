class Solution(object):
    def coinChange(self, coins, amount):
        """
        Time complexity: O(m * n), where m -->coins and n -->amount 
        Space complexity: O(m * n), as we create a 2D DP array to store intermediate results.
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # Create a 2D DP array with dimensions (coins + 1) x (amount + 1) to include 0th row/col
        dp = [[0] * (amount + 1) for _ in range(len(coins) + 1)]

        # Initialize the first row with a large value denoting infinity
        for j in range(1, amount + 1):
            dp[0][j] = 99999

        # Iteration over each coin denomination and target amount
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                # If the current coin denomination is greater than the target amount, skip it
                if coins[i - 1] > j:
                    dp[i][j] = dp[i - 1][j]
                else:
                    # Compute the minimum number of coins required to make the current amount
                    dp[i][j] = min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]])

        # Check if a valid combination of coins exists for the target amount
        if dp[len(coins)][amount] >= 99999:
            return -1

        # Return the minimum number of coins required
        return dp[len(coins)][amount]


