class Solution:
    def coinChange(self, coins: List[int], amount: int) :
        # Created an 2D array. where rows -> coins and columns -> range(0, amount) 
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        for i in range(1,len(dp[0])):   
            dp[0][i] = amount + 1
        
        for i in range(1,len(dp)):      
            for j in range(len(dp[0])):
                # print(dp[i][j])
                if j < coins[i-1]:
                    # print("dp[i][j]: i {} ,j {} ".format(coins[i-1],j))
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], 1 + dp[i][j - coins[i-1]])
        result =  dp[len(coins)][amount]
        
        if amount < result:
            return -1
        
        return result
           
                return result
       
            