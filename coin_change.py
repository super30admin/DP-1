#Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : had to refer to solution in order to came up with with the intuition for the dp formula


# Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        '''
        Approach: bottom up dp
        1. Create dp table of len(amount) + 1, with element of infinity
        2. Setup dp base case: dp[0] = [0]
        3. Iterate the dp table, the index of dp table is the "target amount"
        4. For each index, loop the coins iteratively (only if index >= coin value)
        5. The dp formula is dp[i] = min(dp[i], dp[i - coin] + 1)
        5.1 The intuition is to get the use the previous "target amount" as result but will consider it if it less than current answer dp[i]
        6. return last element of the dp table (only if it's not infinity, else return -1)
        '''
        if amount == 0: return 0
        if len(coins) == 1 and amount < coins[0]: return -1
        
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for i in range(1, len(dp)):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
                    
        return dp[-1] if dp[-1] != float('inf') else -1
