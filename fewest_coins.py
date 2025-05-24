# Time Complexity : O(mn)
# Space Complexity : O(mn)

import sys
def fewest_coins_for_amount(coins, amount) -> int:
    m = len(coins)+1
    n = amount+1
    dp = [[0]*n]*m

    for j in range(1,n):
        dp[0][j] = j
    
    for i in range(1, m):
        for j in range(1, n):
            if j < coins[i-1]:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = min(dp[i-1][j], 1+dp[i][j-coins[i-1]])

    return dp[i][j]


if __name__ == "__main__":
    coins = [1,2,5]
    amount = 11
    print(fewest_coins_for_amount(coins, amount))