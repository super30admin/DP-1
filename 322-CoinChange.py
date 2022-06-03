class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [amount +1]*(amount+1)
        dp[0] = 0
        
        # print(dp)
        for a in range(1, amount+1):
            print(a)
            for c in coins:
                if a - c >=0:
                    dp[a] = min(dp[a] , 1+dp[a-c])
                    
        if dp[amount] != (1+amount):
            return dp[amount]
        else:
            -1
            
        # time complexity = O(amount*len(coins)) = O(n*m)
        # space complexity = O(amount)