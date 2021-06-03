class Solution:
    '''
    Time Complexity: O(S * n) where S is the amount
    Space Complexity: O(S) because we keep everything in the dp table
    1.  Identify the subproblem
    2.  Understand what you need from the subproblem (the number of coins).  You don't need the coins themselves!
    3.  code and solve
    '''
    def coinChange(self, coins: List[int], amount: int) -> int:
        # you need to return the fewest number of coins that make up amount
        
        # create a dynamic programming array to keep amount
        dp = [float('inf')] * (amount + 1) # you use amount + 1 because there is a dummy row.  first column, you fill it with 0.  That's why you need to + 1 to amount.  
        dp[0] = 0
        
        # subproblem: for each coin amount until max amount, find the minimal combination of coins.
        # the theory is that if you already solved a prior value, you can just use the prior result.
        for c in coins: # iterate through coins
            for x in range(c, amount + 1): 
                dp[x] = min(dp[x], dp[x - c] + 1)
        
        if dp[amount] != float('inf'):
            return dp[amount]
        else:
            return -1