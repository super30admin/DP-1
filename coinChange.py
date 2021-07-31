# Time Complexity: O(MN) where N is the number of coins and M is the amount. 
# Space Complexity: O(MN), the auxiliary array we use is of size MxN
def coinChange(coins: list[int], amount: int) -> int:
    if coins == None or len(coins) == 0:
        return -1
    dp = [[0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
    for i in range(1,amount+1):
        dp[0][i] = amount+1 # or use int(float('inf')) as infinity
    for i in range(1, len(dp)):
        for j in range(1, len(dp[0])):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1)
    return dp[-1][-1]