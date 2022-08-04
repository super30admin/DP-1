// Time Complexity : O(n)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes




class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        result = [amount+1]*(amount+1)
        result[0]=0
        for i in range(len(coins)):
            for j in range(1,len(result)):
                if j >= coins[i]:
                    result[j] = min(result[j], result[j-coins[i]]+1)
        
        if result[amount] >= amount+1:
            return -1
        return result[amount]