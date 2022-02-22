# // Time Complexity : O(amount * coins)
# // Space Complexity : O(amount)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        # initialize array with amx amount
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0 # base case
        
        # to calculate min coins until amount
        for a in range(1, amount + 1):
            for c in coins:
                
                # to avoid negative values
                if a-c >= 0:
                    
                    # store min coins for denominations 
                    dp[a] = min(dp[a], 1 + dp[a - c]) # recurrence relation
           
        return dp[amount] if dp[amount] != amount + 1 else -1 # if amount not found return -1