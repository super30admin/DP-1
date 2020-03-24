"""
// Time Complexity : O(C * A) -> A -> Amount, C -> size of coins array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
Algorithm explanation
1) We approach this problem as minimization of optimal subproblem for each coin
selected to sum up the target amount
2) We consider a singular tabular representation (dp)
    - Update dp array as min of prev value and for each value of coins such that coin
    is less than or equal to amount
3) Return dp[amount]
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount+1]*(amount+1)
        dp[0] = 0
        
        for i in range(amount+1):
            for coin in coins:
                if coin <= i:
                    dp[i] = min(dp[i],dp[i-coin]+1)
        
        print(dp)
        return dp[amount]