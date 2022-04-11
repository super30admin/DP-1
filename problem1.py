'''https://leetcode.com/problems/coin-change/ 
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
'''

# Time Complexity : O(N*M) where N is len(coins) and M = amount
# Space Complexity : O(N*M) where N is len(coins) and M = amount
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if coins is None or len(coins) == 0: return -1
        
        dp = [[0]*(amount+1) for _ in range(len(coins)+1)]
        for j in range(1, len(dp[0])):
            dp[0][j] = float('inf')
        
        for i in range(1, len(dp)):
            for j in range(len(dp[0])):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]]+1)
        
        
        return -1 if dp[-1][-1] == float('inf') else dp[-1][-1]
                
            
            
            