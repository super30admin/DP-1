# Time Complexity :  O(m * n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: Here we use a dp array to store the min number of coins needed to make that particular amount using that many number of coins. We consider coin of each value and keep updating the array to find the minimum number of coins needed to form that particular value 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [0 for i in range(amount + 1)]

        for j in range(1, amount + 1):
             dp[j] = float('inf')
        
        for i in range(1, len(coins) + 1):
            for j in range(1, amount + 1):
                if coins[i - 1] > j:
                    dp[j] = dp[j]
                else:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]])

        if dp[-1] >= 99999:
            return -1
        
        return dp[-1]
