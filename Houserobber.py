#Time complexity: O(n)  
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #two variable to use the num or not
        skip,take = 0,nums[0]
        # dp = []
        # for el in nums:
        #     dp.append([0,0])
        # dp[0][1] = nums[0]
        for i in xrange(1,len(nums)):
            #temp skip to account for the take operation because skip might get changed
            tempSkip = skip
            
            #if we skip this, take max of previous--> both options are open
            skip = max(skip,take)
            #if we take this item, we shouldn't have chosen the previous one, so we choose prev skip and add item
            take = tempSkip+nums[i]
            # dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            # dp[i][1] = dp[i-1][0]+nums[i]
            
        return max(skip,take)
        
        
        
        #recursive solution
#         def helper(nums,index,robbings):
#             #base condition
#             if index>=len(nums):return robbings
#             #logic
#             #choose
#             case1 = helper(nums,index+2,robbings+nums[index])
#             #not choose
#             case2 = helper(nums,index+1,robbings)
            
#             return max(case1,case2)
        
#         return helper(nums,0,0)

