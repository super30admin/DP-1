# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
  def coinChange(self, coins: List[int], amount: int) -> int:        
    dp = [[(sys.maxsize-1) for i in range((amount + 1))] for i in range((len(coins) + 1))]
    for i in range(1, (len(coins)+1)):
      dp[i][0] = 0
    for i in range(1, len(coins)+1):
      for j in range(1, (amount+1)):
        if coins[i-1] <= amount:
          dp[i][j] = min((1 + dp[i][j-coins[i-1]]), dp[i-1][j])
        else:
          dp[i][j] = dp[i-1][j]
    return dp[len(coins)][amount] if dp[len(coins)][amount] < sys.maxsize-1 else -1