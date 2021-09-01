#coin_change
# time complexity: O(N*M)
# space complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [float("inf")]*(amount+1)
        dp[0] = 0
        for a in range(1, amount+1):
            for c in coins:
                if c <= a:
                    dp[a] = min(dp[a], 1+dp[a-c])
                                
        return dp[amount] if dp[amount] < float("inf") else -1