#   Time Complexity : 2^ (m+n)
#   Space Complexity :
#   Did this code successfully run on Leetcode : No, time limit exceeded
#   Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach

# Approach 1 : Recursion - Time Limit Exceeded

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        # This condition will never be encountered since coins.length is always greater than 1
        # the value of coins will always be an integer
        
        if coins == None or len(coins) == 0: 
            return 0
        

        return self.helper(coins, 0, amount, 0) 
        
    # recursion is placed on all the variables and added to the helper function
    
    def helper(self, coins: List[int], index: int, amount: int, minCoins: int) -> int:
        
        # base case
        
        if index > len(coins)-1 or amount < 0:
            return -1
        
        if amount == 0:
            return minCoins
        
        # logic
        
        # choose
        case1 = self.helper(coins, index, amount-coins[index], minCoins+1)
    
        # dont choose
        case2 = self.helper(coins, index+1, amount, minCoins)
        if case1 == -1:
            return case2
        
        if case2 == -1:
            return case1
        
        return min(case1, case2)

#   Time Complexity : O(m * n)
#   Space Complexity : O(m * n)
#   Did this code successfully run on Leetcode : Yes
#   Any problem you faced while coding this : No

        
# Approach 2 : Dynamic Programming

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        if coins == None or len(coins) == 0:
            return 0
        
        # added an extra row for the dummy coin 
        
        m = len(coins) + 1
        # added an extra 1 for the amount 0
        
        n = amount + 1
        dp = [[0 for x in range(n)] for y in range(m)] 
        
        # fill in the first column
        # For amount 0, the first column will always be 0.
        
        for i in range(0, m):
            dp[i][0] = 0
        
        # fill in the top row
        # dummy row to be added with a number which is infinity or greater than the amount
        # This ensures that the first row with 0 coins is an invalid case for all the amounts
        
        for j in range(1, n):
            dp[0][j] = amount + 1
        
        for i in range(1, m):
            for j in range(1, n):
                # if denomination is greater than the amount
                if coins[i-1] > j:
                    # zero case
                    dp[i][j] = dp[i-1][j] 
                else:
                    # zero and one case
                    dp[i][j] = min(dp[i-1][j], 1+ dp[i][j-coins[i-1]])
    
        result =  dp[m-1][n-1]
        if result > amount:
            return -1
        return result
                    
                
            
        
        

