# Time Complexity : O(n*c), where n is amount, c is the #coin options
# Space Complexity : O(n), this solution builds up to the value of the amount
# Did this code successfully run on Leetcode : yes

#Any problem you faced while coding this : Initialized dp array to -1, calculation got tricky

# Your code here along with comments explaining your approach
# main idea is dp[i] = min(dp[i], dp[i-c]+1) across all coins c, where i is the amount value 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        dp = [amount+1]*(amount+1)
        dp[0] = 0
        
        for i in range(1, amount+1):
            for c in coins:
                if(c<=i):
                    dp[i] = min(dp[i-c]+1, dp[i])
        
        return dp[amount] if (dp[amount]!=amount+1) else -1
        