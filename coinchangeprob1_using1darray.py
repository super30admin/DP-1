#Time Complexity: O(mn)
#Space Complexity: O(n) as we are using 1d array and overwriting each column to store result of each step
#Did your code run on leetcode : yes
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if (coins==[] or len(coins) == 0): return 0
        
 
        dp = [99999]* (amount + 1)
        
        dp[0] = 0
        
        for coin in coins:
            for j in range(coin,amount+1):
                if j < coin:
                    dp[j] = dp[j]
                else:
                    dp[j] = min(dp[j] , dp[j -coin]+1)

        result = dp[amount]
        if result >= 99999: return -1
        return result
    
        
    


