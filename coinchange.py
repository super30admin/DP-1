# Time Complexity : O(M*N) 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am creating a 1D array to store the minimum number of coins for each amount from 0 to the target amount.
# I will initialize the array with a large value (infinity) and set the first element to 0.
# Then, I will iterate through the coins and update the dp array for each coin and each amount.
# Finally, I will return the minimum number of coins for the target amount, or -1 if it is not possible.

from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [99999] * (amount+ 1)
        dp[0] = 0
        for i in coins:
            for j in range(i,amount +1):
                dp[j] = min(dp[j],1 + dp[j - i])
        return -1 if dp[amount] == 99999 else dp[amount]
        