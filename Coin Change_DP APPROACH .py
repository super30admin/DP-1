
# DYNAMIC PROGRAMMING SOLUTION
# Did problem run on Leetcode: yes 
# Time Complexity: O(m * n), where m: no of rows in dp matrix and n: no of columns in dp matrix
# Space Complexity: O(m * n), is the size of DP martix created

class Solution:
    def coinChange(self, coins, amount):

        # extra row for adding float(inf); extra column for adding 0
        dp = [[0 for i in range(amount+1)] for j in range(len(coins)+1)]

        # populating all the rows of 1st column,
        for i in range(1, len(coins)+1):
            dp[i][0] = 0

        # populating all the columns of 1st row,
        for i in range(1, amount+1):
            dp[0][i] = float('inf')

        # populating the DP Matrix,
        for i in range(1, len(coins)+1):
            for j in range(1, amount+1):
                if j < coins[i - 1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min( dp[i-1][j], dp[i][j-coins[i-1]]+1 ) 
        
        # answer is the last element in the matrix
        result = dp[-1][-1]

        if result == float('inf'):
            return -1
        else:
            return result

output = Solution()
print(output.coinChange(coins=[1, 2, 5], amount=11))

