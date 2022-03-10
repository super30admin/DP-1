 
    # 322. Coin Change

    # Time Complexity : O(m*n)
    # Space Complexity : O(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [float('inf') for _ in range(amount +1)]
        dp[0] = 0        
            
        for i in range(amount+1):
            for c in coins:
                if i-c >= 0:
                    dp[i] = min(dp[i], dp[i-c]+1)
                    
        return dp[-1] if dp[-1] != float('inf') else -1
