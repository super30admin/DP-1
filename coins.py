# linear time and space complexity
def minCoins(coins, amount):
    
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0

    # Iterate through each coin denomination.
    for coin in coins:
        # For each coin, update the 'dp' list to reflect the minimum number of coins.
        for i in range(coin, amount + 1):
            dp[i] = min(dp[i], dp[i - coin] + 1)

    # The value at 'amount' in the 'dp' list represents the minimum number of coins required.
    return dp[amount]

# Example usage:
coins = [1, 2, 5]
amount = 11
min_coins = minCoins(coins, amount)
print("Minimum number of coins required to make change for", amount, "is", min_coins)
