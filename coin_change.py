// Time Complexity : O(n*m) where n is the length of coins array and m is the amount
// Space Complexity : O(n*m) where n is the length of coins array and m is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: We make use of Dynamic programming to solve smaller subproblems 
// to ultimately find soln. to bigger subproblem by storing intermediate results in dp array.




class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        
        for i in range(len(coins)+1):
            dp[i][0]=0
        
        for i in range(1, amount + 1):
            dp[0][i]= amount + 1
            
        for i in range(1,len(coins)+1):
            for j in range(1, amount+1):
                
                if(j< coins[i-1]):
                    dp[i][j]= dp[i-1][j]
                else:
                    dp[i][j]= min(dp[i-1][j], dp[i][j - coins[i-1]] + 1)
        
        return(dp[len(coins)][amount] if(dp[len(coins)][amount] <= amount) else -1)