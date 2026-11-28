# Time Complexity : O(m*n) whewre m is the amount and n is the len of the array
# Space Complexity : O(m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: 1. We initiate the dp array with inf or amount + 1, except for 0 case which is filled with 0 since to make 0 using 0 we need 0 coins.
#          2. At each step we have to make a dicision of either taking or leaving the current coin, skipping the coin case already lies at the current index from the earlier iteration and taking case lies current index - denomination step back plus one coin to consider taking the coin.
#          3. If combinations are not possible we will have inf at the amount index, if possible we will have the min coins needed.

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        dp = [float("inf")] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for j in range(coin, amount + 1):
                dp[j] = min(dp[j], 1 + dp[j-coin])
        return dp[amount] if dp[amount] != float("inf") else -1
        