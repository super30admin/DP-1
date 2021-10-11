class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # TC O(mn) m - coin n - amt
        # SC O(n)
        if coins is None or len(coins)== 0:
            return -1
        
        # DP
        dp = [amount + 1]*(amount + 1)
      
        dp[0] = 0
        for i in range(1, len(dp)):
            for j in range(0, len(coins)):
                if coins[j] <= i:
                    dp[i] = min(dp[i], dp[i - coins[j]]+1)
                    
        result = dp[amount]
        if result > amount:
            return -1
        return result

        
        def exhaustive_helper(coins, amt, ind, mincoin):
            
            # base
            if amt == 0:
                return mincoin
            if ind == len(coins) or amt < 0:
                return -1
                
              
            # logic
            #not choose
            case1 = helper (coins, amt,ind + 1,mincoin)
            
            
            # choose
            case2 = helper (coins, amt -coins[ind], ind, mincoin + 1)
            if case1 == -1:
                return case2
            if case2 == -1:
                return case1
            return min(case1, case2)
            
        # return helper (coins, amount, 0, 0)
        
