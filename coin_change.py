'''
Approach: Create a matrix of size(coinsxamount). Add a dummy array on top for impossible case. if ith coins row is greater than jth amount col, copy (i-1)th col value, else min of i-1 and i[j-coins[i-1]] and add 1.
Return the last element of last row.

Time complexity: O(amount * coins)
Space complexity:O(amount*coins)

Passes all testcases in leetcode

'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = []
        x = []
        y = []
        
        for j in range(amount+1):
            x.append(amount+30)
            y.append(0)
        dp.append(x)
        for i in range(len(coins)):
            dp.append(y)
        
        for i in range(1,len(dp)):
            for j in range(1, len(dp[0])):
                if j < coins[i-1]:
        
                    dp[i][j] = dp[i-1][j]
                
                else:
                    dp[i][j] = min(dp[i-1][j],1+dp[i][j-coins[i-1]])
                    
            #print(dp[i])
            
        result = dp[-1][-1]
        
        print(result)
        
        
        if result >= amount+30: 
            return -1
        else: 
            return result
        
