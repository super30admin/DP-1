# Time complexity: O(amount*n)
# Space complexity: O(n)
# Does this code run on leetcode: yes
# Dif you face any difficulty in coding this: No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount+1] * (amount+1)
        # base case
        dp[0] = 0
        
        for n in range(1, amount+1):
            for m in coins:
                if n-m >= 0:
                    dp[n] = min(dp[n], 1+dp[n-m])
        return dp[amount] if dp[amount] != amount+1 else -1
        