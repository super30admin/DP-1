#time complexity:O(row*col) where row and col are num of coins and amt
#space complexity:o(row*col) where row and col are num of coins and amt
#passed all cases on LeetCode:yes
#difficulty faced:
# comments:in the code
# https://leetcode.com/problems/coin-change/
class Solution:
    def coinChange(self, coins: 'List[int]', amount: int) -> int:
        #w, h = len(coins)+1, amount+1
        row,col = len(coins)+1, amount+1
        #dp = [0*col]*row
        dp = [[0 for x in range(col)] for y in range(row)] 
        
        #storing inf in 1st row when coin value is 0, inf is amt+1 here
        for j in range(1,col):
            dp[0][j] = amount+1
            #print (dp[0][j])
            
        for i in range(1,row):
            for j in range(1,col):
                if(j < coins[i-1]):
                    #j is the amount and if it is less than coins value then just copy from row above
                    dp[i][j] = dp[i-1][j]
                
                else:
                    #choose min of row above or use 1 coin in this row and get coins cal back at index amt-coinvalue
                    dp[i][j] = min( dp[i-1][j], 1+dp[i][j- coins[i-1]] )
        #if we get infinity then return -1             
        if( dp[row-1][col-1] == amount+1): return -1 
        #have to return the last row and col
        return dp[row-1][col-1]
    
    
    """
   imagine this matrix 
 for the coins of [1,2,5] and change of 11:
   0   1   2   3   4   5   6   7   8   9   10  11
 0 0  inf inf inf inf inf inf inf inf inf inf inf 
 1 0   1   2   3   4   5   6   7  8    9   10  11
 2 0   1   1   2   2   3   3   4   4   5   5   6
 5 0   1   1   2   2   1   2   2   3   3    2   3 
 """