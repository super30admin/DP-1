#Time Complexity : O(m*n)
#Space Complexity : O(n)
#Any problem you faced while coding this : none

#Your code here along with comments explaining your approach

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        m=len(coins)
        n=amount
        #dp_matrix=[[0 for _ in range(n+1)] for _ in range(m+1)]
        dp_matrix=[0 for i in range(n+1)] #dp[0] is set to 0, as the number of coins needed to make amount 0 is 0
        for j in range(1,n+1):
            #dp_matrix[0][j]=float('inf')
            dp_matrix[j]=float('inf')   #base case is set to infinity, as the number of coins to make the amount using 0 coins is infinity
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                if j<coins[i-1]:    # if the sum is less that the coin denomination then no change 
                    dp_matrix[j]=dp_matrix[j]
                else:
                    dp_matrix[j]=min(dp_matrix[j],1+dp_matrix[j-coins[i-1]])  #else find the min between not choosing the coin and choosing the coin
        if dp_matrix[n] == float('inf'): # if the amount cannot be obtained from the coins return -1
            return -1
        else:
            return dp_matrix[n]         # the last element in the matrix holds the min number of coins 