"""
// Time Complexity : o(s*n) where s = amount, n = number of coins
// Space Complexity : o(s), Extra space for memorization of table 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
"""


def coin_change(coins, amount):
    # array of size amount + 1, to handle 0
    # 0 .... amount
    dp = [amount+1]*(amount+1)
    dp[0] = 0  # base case at 0

    for a in range(1, amount+1):
        for c in coins:
            # if the amount is non-negative
            # we can search in this direction
            if a - c >= 0:
                dp[a] = min(dp[a], 1 + dp[a-c])

    # return amount if its not the original value
    if dp[amount] != amount + 1:
        return dp[amount]
    return -1


# Driver code
print(coin_change([1, 2, 5], 11))
