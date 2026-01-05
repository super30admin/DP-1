#recursive solution

from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:

        def helper(coins, idx, amount):#never store result as a recursion parameter
            #base case
            if idx == len(coins) or amount < 0:
                return float('inf')

            if amount == 0:
                return 0 #leaf node so we won't be using any more coins.

            #no choice
            case1 = helper(coins, idx+1, amount)

            #choice
            case2 = 1+helper(coins, idx, amount-coins[idx]) #accounting for the 1 coin we are taking here so '1+'

            return min(case1,case2)#because we want the min no of coins

        result = helper(coins, 0, amount)
        if result == float('inf'):
            return -1
        else:
            return result

#NOTES:
# if idx == len(coins) or amount < 0:
#         return -1
# we can't return -1 here because min(-1, valid no) always gives -1 which is incorrect ans. So return infinity
#also in python float('inf')+1 is same as float('inf')
# Time Complexity: exponential depends on no of coins and the amount. We have two constraints : coins and amount.
# Time Complexity:
# O(2^(m+n)) , m is the number of coins and n is the amount.
# Space Complexity:
# O(m+n) - recursive stack space

#DP solution using 2D matrix

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins) #rows
        n = amount #cols

        #create a 2D matrix of (m+1)*(n+1) dimension
        dp = [[0] * (n+1) for _ in range(m+1)] #we will have m+1 and n+1 rows and cols because we added a 0th column and 0th row above

        for j in range(1,n+1):
            dp[0][j] = float('inf') #dummy row except first cell rest all are infs

        #now lets fill the actual table
        for i in range(1,m+1):#skip first row which is the dummy row
            for j in range(n+1): #cant skip first column.
                if j < coins[i-1]: #amount < coin then not possible i-1 to map to index in original coins array because now we have a preceeding 0 in coins array due to dummy row [0 1 2 5] instead of [1 2 5]
                    dp[i][j] = dp[i-1][j] #copy the value from the prev row as it is
                else:
                    dp[i][j] = min(dp[i-1][j], 1+dp[i][j - coins[i-1]]) #if condition above ensures dp[i][j - coins[i-1] is not out of bounds. as we are checking if j < coins[i-1] case.
                    #taking the min of : case where we don't choose that coin and case where we choose the coin + 1. 

        return -1 if dp[m][n] == float('inf') else dp[m][n]     
    
#Time and Space Complexity: O(m*n) of the 2D matrix.

#using a 1D array, Here we basically overwritte the single 1-D array with new values for every
#iteration
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        #optimizing using 1D array
        #basically we are just overwritting each row
        m = len(coins) #rows
        n = amount #cols

        #create a 1D array of (n+1) dimension
        dp = [0] * (n+1)

        for j in range(1,n+1):
            dp[j] = float('inf') 

        #now lets fill the actual table
        for i in range(m):
            for j in range(n+1): 
                if j < coins[i]: #amount < coin then not possible i-1 to map to index in original coins array because now we have a preceeding 0 in coins array due to dummy row [0 1 2 5] instead of [1 2 5]
                    dp[j] = dp[j] #copy the value from the prev row as it is
                else:
                    dp[j] = min(dp[j], 1+dp[j - coins[i]]) #if condition above ensures dp[j - coins[i-1] is not out of bounds. as we are checking if j < coins[i-1] case.
                    #taking the min of : case where we don't choose that coin and case where we choose the coin + 1. 

        return -1 if dp[n] == float('inf') else dp[n]     

# Time Complexity: O(m*n)
# Space Complexity: O(n)