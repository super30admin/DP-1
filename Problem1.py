# Time Complexity : O(S∗n). On each step the algorithm finds the next F(i) in n iterations, where 1≤i≤S. Therefore in total the iterations are S*n.
# Space Complexity : O(S)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        for coin in coins:
            for i in range(coin, amount+1):
                dp[i] = min(dp[i], dp[i - coin] + 1)
        
        if dp[amount] == amount + 1:
            return -1
        else:
            return dp[amount]
