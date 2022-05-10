# Time Complexity : O(amount*number of coins)
# Space Complexity : O(amount*number of coins)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        self.dp = [[None for i in range(amount+1)] for j in range(len(coins))]
        value = self.coinChange2(coins,0,amount)
        
        if value == float('inf'):
            return -1
        return value
        
    def coinChange2(self, coins: List[int], index: int, amount: int) -> int:
        
        if (amount == 0):
            return 0
        
        if amount < 0 or index == len(coins):
            return float('inf')
        
        if self.dp[index][amount] == None:
            notChoose = self.coinChange2(coins,index+1,amount)

            choose = self.coinChange2(coins,index,amount-coins[index])

            if choose != float('inf'):
                choose = 1 + choose

            self.dp[index][amount] = min(notChoose,choose)
        return self.dp[index][amount]