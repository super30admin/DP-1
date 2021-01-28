# Time Complexity: O(n*m) = O(n)
# Space Complexity: O(n*m)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins) + 1
        m = amount + 1
        max_m = 99999 # or amount + 1
        res = [[None]*m]*n
        
        #initializing first row and col of res matrix
        # row --> coins
        for i in range(n):
            res[i][0] = 0
        #col --> amount
        for j in range(1,m):
            res[0][j] = max_m
        
        # initialize the matrix --> (n --> coins, m --> amount)
        # start from 1 as the other rows and cols are assigned
        for i in range(1,n):
            for j in range(1,m):
                # if j is less than coin value then
                if j < coins[i-1]:
                    # update it with above value
                    res[i][j] = res[i-1][j]
                else:
                    # update it with min of above value and the j- coins[i-1] value
                    res[i][j] = min(1 + res[i][j - coins[i-1]], res[i-1][j])
        # if the last value in the matrix is not the maximum value then
        if res[n-1][m-1] != max_m:
            # return the final number of coins calculated
            return res[n-1][m-1]
        # else return -1 as the solution could not be found
        return -1