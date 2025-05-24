# Memoization
# Time complexity: O(amount * len(coins))
# Space complexity: O(amount * len(coins))

def coinChange(coins, amount):
    memo = {}

    def helper(i, amount):
        if (i, amount) in memo:
            return memo[(i, amount)]
        if i == 0:
            if amount % coins[i] == 0:
                return amount // coins[i]
            else:
                return float('inf')
        take = float('inf')
        if amount >= coins[i]:
            take = 1 + helper(i, amount - coins[i])
        notTake = helper(i - 1, amount)
        memo[(i, amount)] = min(take, notTake)
        return memo[(i, amount)]

    result = helper(len(coins) - 1, amount)
    return result if result != float('inf') else -1



# 2D DP
# Time complexity: O(amount * len(coins))
# Space complexity: O(amount * len(coins))
def coinChange(coins, amount):
    dp = [[float('inf')] * (amount + 1) for _ in range(len(coins))]

    for i in range(len(coins)):
        dp[i][0] = 0

    for j in range(amount + 1):
        if j % coins[0] == 0:
            dp[0][j] = j // coins[0]

    for i in range(1, len(coins)):
        for j in range(1, amount + 1):
            take = float('inf')
            if j >= coins[i]:
                take = 1 + dp[i][j - coins[i]]
            notTake = dp[i - 1][j]
            dp[i][j] = min(take, notTake)

    return dp[-1][-1] if dp[-1][-1] != float('inf') else -1


  
  
# 1D DP
# Time complexity: O(amount * len(coins))
# Space complexity: O(amount)
def coinChange(coins, amount):
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0

    for coin in coins:
        for j in range(coin, amount + 1):
            dp[j] = min(dp[j], dp[j - coin] + 1)

    return dp[-1] if dp[-1] != float('inf') else -1
