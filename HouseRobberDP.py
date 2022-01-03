# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if nums == None:
            return 0
        n = len(nums)
        dp= [ [ 0 for j in range(2) ] for i in range(len(nums)) ]
        
        dp[0][1] = nums[0]
        
        for i in range(1,len(nums)):
            #skip
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            #take
            dp[i][1] = dp[i-1][0] + nums[i]
            
        return max(dp[n-1][0],dp[n-1][1])


# Solution using just variables skip and take instaed of 2d array

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if nums == None:
            return 0
        n = len(nums)
        #dp= [ [ 0 for j in range(2) ] for i in range(len(nums)) ]
        skip =0 
        take= nums[0]
        
        for i in range(1,len(nums)):
            #assign previous skip in temp
            temp = skip
            #skip
            skip= max(skip, take)
            #take
            take= temp + nums[i]
        return max(skip,take)
            
        
            