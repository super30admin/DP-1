# As taught in class, the  solution here will be to design a grid and memoise the result to get solution
# Time Complexity: O(n^2)
# Space Complexity: O(row * columns)
def coinChange(coins,amount):
    if (coins is None or len(coins) is None):
        return 0
    dp = [[0 for l in range(len(coins)+2)] for m in range(amount + 2)]
    for i in range(1,len(dp)):
        dp[0][i] = amount + 1
    for j in range(1,len(dp)):
        for k in range(1,len(dp[0])):
            if (k < coins[j-1]):
                dp[j][k] = dp[j-1][k]
            else:
                dp[j][k] = min(dp[j-1][k], 1 + dp[j][j - coins[i-1]])
    return dp[len(dp)-1][len(dp[0])-1]





coins = [1,2,5]
amount = 13
coinChange(coins,amount)
    