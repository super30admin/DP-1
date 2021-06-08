class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        #defining the base case
        if(amount == 0):
            return 0

        #Defining the Minimum array list
        M = [float('inf')]*(amount + 1)

        #initializing the array intial value with 0
        M[0] = 0

        #Loop over values of coin list
        for j in coins:
            #Loop over values finding the minimum
            for i in range(j,amount+1):
                M[i] = min(M[i],M[i - j]+1)
    
        #If the minumum number of coins is not equal to infinity
        if M[amount] != float('inf'):
            return M[amount]
        else:
            return -1
            

#This problem involves finding out the minumum numbef of coins needed for an amount to sufficed.
#Time complexity - O(S*n) where S isthe amount
#Space complexity - O(S)
