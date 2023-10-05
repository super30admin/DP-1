# // Time Complexity : O(amount+len(coins))
# // Space Complexity : O(amount)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : took over one hour to understand

# going to initialize a 1D-array with inf values except for first value- first value is 0 ( 0 coins needed for 0 amount)> the size of array is amount+1
# for each coin, loop inside array and update the number of coins needed to reach that amount. it would be min(current number of coins needed, 1+number of coins needed for the i-coin amount)
class Solution(object):
    def coinChange(self, coins, amount):
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount + 1):
                dp[i] = min(dp[i], dp[i - coin] + 1)
        if dp[amount] == float('inf'):
            return -1
        return dp[amount]