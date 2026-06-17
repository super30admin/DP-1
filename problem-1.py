# LEETCODE PROBLEM 322 COIN CHANGE
# TIME COMPLEXITY:O(N*M) where N is the number of coins and M is the amount
# SPACE COMPLEXITY: O(M) 
# Any problem you faced while coding this: None


class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        #Approach 1
        # n=len(coins)+1
        # m=amount+1
        # matrix=[[0]*m for _ in range(n)]
        # #(matrix)
        # for i in range(1,m):
        #     matrix[0][i]=float('inf')
        
        # for i in range(1,n):
        #     for j in range(1,m):
        #         if (j>=coins[i-1]):
        #             #matrix[i][j]=min(matrix[i-1][j-coins[i-1]]+1,matrix[i-1][j])
        #             matrix[i][j] = min(matrix[i][j-coins[i-1]] + 1, matrix[i-1][j])
        #         else:
        #             matrix[i][j]=matrix[i-1][j]
        # ans=matrix[n-1][m-1]
        # return ans if ans !=float('inf') else -1
    
        #Approach 2

        m=amount+1
        matrix=[float('inf')]*m
        matrix[0]=0
        for i in coins:
            for j in range(i,m):
                matrix[j]=min(matrix[j],matrix[j-i]+1)
        return -1 if matrix[m-1]==float('inf') else matrix[m-1]