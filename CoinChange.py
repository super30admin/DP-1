# // Time Complexity : O(n*m) to create the matrix + O(n*m) for loops total O(n*m)
# // Space Complexity : O(n*m) saving the values 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : watched the video again.

class CoinChange(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # check if by adding the coins in the array can return the amount
        # check which path of the coins is retuning the amount with lesser number of coins 
        # so keep track of the number of coins in each path which the sum is equal to amount 
        # since we need to see possibility of taking or not taking each coin and check the min number of coins for sum
        # we are havign an overlapping solving of subproblems so its best to use the dynamic programming
        # We have two deciding factors 1 is the coin and the other is the amount so i will be using a matrix 
        # where row will be the coins and the col will be the from the rang 0 to amount 
        # so at a place when we want to get the minimum number of coins used the amount possible with coin[i] be it only this coin or combination with some other coin
        # we can easily retrive it

        # constructing a matrix with default value 0
        rows, cols = len(coins)+1, amount+1
        dp = [[0] * cols for _ in range(rows)] 
    
        # intializing the first row the dummy row with infinity because its not possible to make the amount with 0 coins
        for j in range(1, cols):
            dp[0][j] = float('inf') -10 # -10 to avoid stack overflow 

        for i in range(1, rows): # we are parsing from the 1st index as 0th index row is our dummy array 
            for j in range(cols):

                # if the amount is less than the coin then we cannot make the amount with this coin so we just return infinity
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # if the amunt is not less than the coin and equal or greater then we can count some coins here to make amount
                else: 
                    # dp[i-1][j] is the count , that with the number previous coins the amount is formed
                    # other way is considering this coin 1 + and the rest amoutn so j - coins[i-1] 
                    # so 1+ number of coins used to get the rest amount 
                    dp[i][j] = min(dp[i-1][j], 1+ dp[i][j- coins[i-1]])

        
        if dp[rows-1][cols-1] == float('inf') -10:
            return -1

        return dp[rows-1][cols-1]






        


        

        

        


