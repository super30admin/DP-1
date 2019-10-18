# leet code -322
# Dynamic Programming
# passed all test cases
# time complexity =O(N^2)
#space complexity=O(N)
#Approach - we need to create a matrix of size((number of coins+1 * (amount+1)). Let the first row be filled with infinity except first column in all the rows. Those values are filled with zero. Till the column reaches the coin denomination the matrix is filled with previous row values and then it compared with min value of (previous rowth column and the (current column -coin denomination))




class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        i,j=0,0
        rows,col=len(coins)+1,amount+1
        dp=[[0 for i in range(col)] for j in range(rows)]
        
     
        for i in range(rows):
            dp[i][0]=0
        for j in range(1,col):
            dp[0][j]=99999
        for i in range(1,rows):
            for j in range(1,col):
                if j<coins[i-1]: #extra row of zero added
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
      
        result=dp[rows-1][col-1]
        
        if result >=99999 :
            return -1 
        else :
            return result
        
        
# Recursive solution

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        return self.helper(coins,amount,0,0)
    
    def helper(self,coins,amount,i,min_num):
        
        
        #base cases
            if (amount<0 or i> len(coins)):
                return -1
        
            if (amount==0):
                return min_num
        
        #case1 choosing the coin
            case1=self.helper(coins,amount-coins[i],i,min_num+1)
        
        #case2  not choosing the coin
            case2 = self.helper(coins,amount,i+1,min_num)
        
        if (case1 ==-1):
            return case2
        elif case2 ==-1:
            return case1
        else:
            return min(case1,case2)

    
                    
            
