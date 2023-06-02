#Time complexity is : O(m*n) where m is length of the array coins, n is the amount
#Space complexity is : O(m*n) where m is length of the array coins, n is the amount
#Code ran successfully on leetcode
#Faced no problems while coding

#Coin change problem - to find the fewest number of coins that we need to make up that amount
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        #Creating the two dimensional array
        self.dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)]
        #taking the first value as 0 to handle the edge case scenario
        self.dp[0][0]=0
        #As we will be taking the minimum value in the logic, we are taking 99999 as intial values
        #We will be taking 0 as one of the coin such that the logic works accordingly 
        for j in range(1,amount+1):
            self.dp[0][j]=99999
        #Looping through the coins array
        for i in range(1,len(coins)+1):
            #Looping through the amount array
            for j in range(1,amount+1):
                #If the coin value is greater than amount, we will directly take the previous coin values
                if(coins[i-1]>j):
                    self.dp[i][j]=self.dp[i-1][j]
                else:
                    #Here we will be taking minimum value of the amount related to previous coin and the 1+self.dp[i][j-coins[i-1]]
                    self.dp[i][j]=min(self.dp[i-1][j],1+self.dp[i][j-coins[i-1]])
        
        #If the final value in the self.dp is greater than or equal to 99999, we will return -1
        if(self.dp[len(coins)][amount]>=99999):
            return -1
        else:
            #Here we will return the value in self.dp[len(coins)][amount] 
            return self.dp[len(coins)][amount]

