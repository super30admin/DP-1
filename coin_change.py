# Time Complexity: O(m*n)
# Space Complexity: O(n) where n represents the amount specified.
def coin_change(coins, amount):
    """
    Calculate the minimum number of coins needed to make a given amount.

    Args:
        coins: A list of coin denominations.
        amount: The target amount to make change for.

    Returns:
        The minimum number of coins required, or -1 if the amount cannot be made.
    """

    # Initialize a DP array where dp[i] represents the minimum coins needed for amount i.
    # Initialize with amount + 1 (a value larger than any possible valid count) to represent infinity, except for dp[0] which is 0 (0 coins for amount 0).
    dp = [amount + 1] * (amount + 1)
    dp[0] = 0

    # Iterate through each amount from 1 up to the target amount.
    for i in range(1, amount + 1):
        # For each amount, iterate through the available coin denominations.
        for coin in coins:
            # If the current coin can be used to make the current amount (i.e., coin <= i)
            if coin <= i:
                # Update dp[i] with the minimum of its current value and 1 (for the current coin) + the minimum coins needed for the remaining amount (i - coin).
                dp[i] = min(dp[i], dp[i - coin] + 1)

    # If dp[amount] is still amount + 1, it means the amount cannot be made.
    if dp[amount] == amount + 1:
        return -1
    else:
        return dp[amount]
