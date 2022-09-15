# Time Complexity : O(amount * len(coins))
# Space Complexity : O(amount)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
def coinChange(coins, amount):
    if coins == None or len(coins) == 0:
        return -1
    dp = [amount+1] * (amount + 1)
    dp[0] = 0
    for a in range(1,amount+1):
        for c in coins:
            if a-c >= 0:
                dp[a] = min(dp[a], 1+ dp[a-c])
    return dp[amount] if dp[amount] != amount + 1 else -1


coins = [1,2,5]
amount = 11
print(coinChange(coins,amount))