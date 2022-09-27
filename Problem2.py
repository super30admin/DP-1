# Time Complexity : O(mn) where n is the number of houses
# Space Complexity : O(n) we are creating a matrix of size mn in storing in a variable 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Yes it is difficult ot create a 2D array in python


# Your code here along with comments explaining your approach : - Here we create the table by selcting whether to pick the house for robbing or not and based on that we keep the max and put it in next row which would help to skip the adjacent house

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp=[]
        
        for i in range(0,len(nums)):
            cols = []
            for j in range(0,2):
                cols.append(0)
            dp.append(cols)
        
        for i in range(0,n):
            if i ==0:
                dp[0][1] = nums[0]
                continue
            for j in range(2):
                if j ==0:
                    dp[i][j] = max(dp[i-1][j+1],dp[i-1][j])
                else:
                    dp[i][j] = dp[i-1][j-1] + nums[i]
        return max(dp[n-1][0],dp[n-1][1])
                
            

            