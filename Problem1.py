# Time Complexity : O(m x n), where m are no of coins +1  and  n is range of the amount + 1
# Space Complexity : O(m x n), where m are no of coins +1  and  n is range of the amount + 1
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    # # TC = O(2^n) | SC = O(2^n)
    # def coinChange(self, coins: List[int], amount: int) -> int:
    #     # Greedy Approach 
    #     if not coins or len(coins) == 0 :
    #         return 0 
    #     return self.helper(coins,amount,0,0)
    
    # def helper(self,coins,amount,index,change):
    #     #base case 
    #     if amount == 0 :
    #         return change 
    #     if amount < 0 or index == len(coins):
    #         return -1
        
    #     #logic 
    #     # choose 
    #     case1 = self.helper(coins,amount-coins[index],index,change+1)
    #     # not choosen
    #     case2 = self.helper(coins,amount,index+1,change)
        
    #     if case1 == -1:
    #         return case2 
    #     if case2 == -1:
    #         return case1 
        
    #     return min(case1,case2)
        
    def coinChange(self,coins,amount):
        dp = [[float("inf") for _ in range(amount+1)] for _ in range(len(coins)+1)]
        for i in range(len(dp)):
            dp[i][0] = 0 
         
        row = len(dp)
        col = len(dp[0])
        
        for i in range(1,row):
            for j in range(1,col):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-coins[i-1]] + 1 )
        if dp[-1][-1] == float("inf"):
            return -1 
        return dp[-1][-1]
        

if __name__ == "__main__":
    s = Solution()
    coins = [1,2,5]
    amount = 11
    print(s.coinChange(coins,amount))
        