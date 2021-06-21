# Time Complexity : O(n) n is the length of nums array
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I used technique of dynamic programming, I created a dp array with size of amount+1, and initialized the 0th index to 0.
# for each coin we can get the number of coins from the amount-coin +1 as we are using that coin.


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')]*(amount+1)
        dp[0] = 0

        for coin in coins:
            for i in range(coin,len(dp)):
                dp[i] = min(dp[i], dp[i-coin]+1)
        return dp[-1] if dp[-1] != float('inf') else -1