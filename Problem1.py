#Problem 1 : https://leetcode.com/problems/coin-change/
#Test Cases Passed on LeetCode
#Time Complexity-O(n*T) where T is the target and n is the no of coins
#Space Complexity-O(n*T) *Please confirm if it is correct or not

class Solution:
    def coinChange(self, coins, amount):

        cols=amount+1
        rows=len(coins)
        # T = [[0] + [float('inf')] * amount]*rows
        T=[[0 if col == 0 else float("inf") for col in range(cols)] for row in range(rows)]
        #print(T)

        for i in range(rows):
            for j in range(1,cols):
                
                if j < coins[i]:
                    T[i][j] = T[i - 1][j]
                else:
                    T[i][j] = min(T[i - 1][j], 1 + T[i][j - coins[i]])
                        
        if T[rows-1][cols-1]>=float("inf"):
            return -1
        else:
            return T[rows-1][cols-1]
sol=Solution()
coins = [1, 2, 5]
amount = 11
print(sol.coinChange(coins,amount))
