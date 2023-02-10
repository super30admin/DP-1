# Time Complexity :
# O(MN) - M is the target amount, N is the number of available coins

# Space Complexity :
# O(MN) - M is the target amount, N is the number of available coins

# Did this code successfully run on Leetcode :
#Yes

#We follow an exhaustive approach - at each step we see if we get to a solution by picking a particular element or leaving it out. We do this at every step for each coin until the target amount is reached. 
#We then return the minimum among these
#To achieve this, we store a DP array - where we use the previously solved subprolbems answers to find the number of coins required for a newer problem and find the number of coins required in all cases and return the final minimum amount found

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        n = len(coins)
        m = amount
        dp_matrix = [[0] * (m+1) for i in range(n+1)]
        max_val = 10**5 + 2

        for i in range(0,m+1):
            dp_matrix[0][i] = max_val
        for i in range(1,n+1):
            for j in range(1,m+1):
                if j < coins[i-1] :
                    dp_matrix[i][j] = dp_matrix[i-1][j]
                else :
                    dp_matrix[i][j] = min(dp_matrix[i-1][j],1+dp_matrix[i][j-coins[i-1]])
        
        if dp_matrix[n][m] == max_val :
            return -1
        return dp_matrix[n][m]
