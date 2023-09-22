'''
DP Method:
1. We have a matrix of size m+1 x n+1 where m is the number of coins and n is the amount. 
2. We populate this matrix based on some conditions.
3. We return the last element in the matrix.
TC: O(m*n) 
SC: O(m*n) 
where m is the number of coins and n is the amount
'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:


        if coins == None or len(coins) == 0:
            return -1
        
        # Rows of dp array are number of coins + 1 so storing num of coins
        m = len(coins)
        # Columns in dp array
        n = amount

        # Initialize the dp array with zeros matrix of size m+1 x n+1
        dp =[[0] * (n+1) ] * (m+1)

        # Make the first row as amount+1 (works like inf) 
        for j in range(1,n+1):
            dp[0][j] = amount + 1
        
        # We compute from row 1, column 1 
        for i in range(1,m+1):
            for j in range(1,n+1):
                # If the amount is less than the coin, we can assume coins required to make that amount would be the same as the case where this coin was not included (prev row) 
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                # Check if including this coin would get us same amount with lesser num of coins OR not
                #  
                else:
                    dp[i][j] = min(1+dp[i][j-coins[i-1]],dp[i-1][j])
                
        if dp[m][n] == amount+1:
            return -1
        return dp[m][n]
