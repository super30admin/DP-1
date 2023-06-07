class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # Initialize the dp array with a maximum value (amount + 1)
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0

        # Iterate through all amounts from 1 to the target amount
        for i in range(1, amount + 1):
            # Check all coin denominations
            for coin in coins:
                # Only update the dp array if the current coin is less than or equal to the current amount
                if coin <= i:
                    # Choose the minimum between not using the current coin and using the current coin
                    dp[i] = min(dp[i], dp[i - coin] + 1)

        # If dp[amount] remains unchanged, it means the target amount cannot be made up
        if dp[amount] == amount + 1:
            return -1

        return dp[amount]