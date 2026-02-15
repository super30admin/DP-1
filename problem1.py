## Problem1 (https://leetcode.com/problems/coin-change/)

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m = len(coins)
        n = amount
        my_arr = [[0]*(n+1) for _ in range(m+1)]
        for i in range(1,n+1):
            my_arr[0][i]=99999
        for i in range(1,m+1):
            for j in range(n+1):
                if j < coins[i-1]:
                    my_arr[i][j] = my_arr[i-1][j]
                else:
                    my_arr[i][j] = min(my_arr[i-1][j],1+my_arr[i][j-coins[i-1]])
        return my_arr[m][n] if my_arr[m][n] != 99999 else -1