# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No


# drawing decision tree analyzing repeating subproblems and saving the details
# to access

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        rows = len(coins) + 1
        columns = amount + 1
        
        arr = [[0 if i ==0 else amount+1 if j==0 else 0 for i in range(columns)] for j in range(rows)]
        
        for i in range(1,rows):
            coin = coins[i-1]
            for j in range(1,columns):
                if j < coin:
                    arr[i][j] = arr[i-1][j]
                else:
                    arr[i][j] = min(arr[i-1][j],1+arr[i][j-coin])
        result = arr[rows-1][columns-1]
        if result > amount:
            return -1
        else:
            return result