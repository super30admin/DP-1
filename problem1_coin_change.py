#using tabluation
# // Time Complexity : O(nxm)
# // Space Complexity : O(m+1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [(amount+1) for x in range(amount+1)]
        
        dp[0] = 0
        for a in range(1, amount+1):
            for c in coins:
                if a-c>= 0:
                    dp[a] = min(dp[a], 1+dp[a-c])
        return dp[amount] if dp[amount] != amount +1 else -1

#using memoization
# // Time Complexity : O(nxm)
# // Space Complexity : O(nxm)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution2:
    def recursiveCoinChange(self, coins, index, amount, dp):
        if amount == 0:
            return 0
        
        if amount<0 or index == len(coins):
            return sys.maxsize
        
        if(dp[index][amount]==0):
            select = self.recursiveCoinChange(coins, index, amount-coins[index], dp)
            
            if(select != sys.maxsize):
                select += 1
            
            notselect = self.recursiveCoinChange(coins, index+1, amount, dp)
            
            dp[index][amount] = min(select, notselect)
            
        return dp[index][amount]
    
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[0 for x in range(amount+1)]for x in range(len(coins)+1)]
        ans = self.recursiveCoinChange(coins, 0, amount, dp)
        
        if ans == sys.maxsize:
            return -1
        else:
            return ans
        
