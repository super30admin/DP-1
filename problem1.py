// Time Complexity : O(nm) 
// Space Complexity : O(nm) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n=len(coins)+1              //rows
        m=amount+1                  //coloumns
        dp=[[None]*m ]*n            
        for j in range(1,m):                
            dp[0][j]=amount+1
            
        for i in range(n):
            dp[i][0]=0
            
        for i in range(1,n):
            for j in range(1,m):
                if j<coins[i-1]:            //if amount is less than current max price coin then the number of coins will be equal to the coins required by current amount without presence of current max price coin  
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(1+dp[i][j-coins[i-1]],dp[i-1][j])              //coins required by current amount will be min of (1+coins required by amount j-coins[i-1]) or (coins required by current amount without presence of current max price coin)
        return dp[n-1][m-1] if dp[n-1][m-1]<=amount else -1
