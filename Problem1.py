class Solution(object):
#     // Time Complexity : O(n*m) where n is the number of coins and m is the amount
# // Space Complexity : O(m)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : yes, looked at video once.
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        # two things to consider
        # check if by adding the coins in the array can return the amount if not return -1
        # check which path of the coins is retuning the amount with lesser number of coins, return the min number of coins used 
        # so keep track of the number of coins in each path which the sum is equal to amount 
        # since we need to see possibility of taking or not taking each coin and check the min number of coins for sum
        # we are havign an overlapping solving of subproblems so its best to use the dynamic programming
        # We have two deciding factors 1 is the coin and the other is the amount so I am thinking of using a matrix 
        # but i think we can make it even efficient, we don't need to store the whole matrix, we only need the previous dp array to calcualte the min 
        # so instead of matrix using a single array and checking min with that and iterating 

        # constructing an array
        rows = len(coins) +1 
        cols = amount+1

         # intially set each row with infinity and as we go when we find the min value than this we will update. 
        dp = [float('inf') -10] * cols  # intiating an array of size cols, -10 is to avoid the stack overflow

        dp[0] = 0 # we need 0 coins to make an amount 0 so setting dp[0] as 0

        
        for i in range(1, rows): 
            for j in range(cols):

                # if the amount is less than the coin then we cannot make the amount with this coin so we just leave as it is
                # infinity or the count of previous coins to get the amount
                if j < coins[i-1]:
                    dp[j] = dp[j]
                # if the amunt is not less than the coin and equal or greater then we can count some of this coin here to make amount
                else: 
                    # so in this case we can find the min number of coins used to make amount by considering min of two cases
                    # one the number of pervious coins used to make the amount i.e dp[j]
                    # other is by using this number so 1 + rest of the amount once this coin is used dp[j-coins[i-1]] 
                    dp[j] = min(dp[j], 1 + dp[j - coins[i-1]])

        
        if dp[cols-1] == float('inf') -10: # if its infinity then return -1 as we were not able to make the amount using the coins
            return -1

        return dp[cols-1]





        


        

        

        


