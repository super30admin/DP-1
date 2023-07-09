# Time Complexity: O(n) where n = length of nums
# Space Complexity: O(1).
# Did this code successfully run on Leetcode : Yes
# DP with 1D space as only 1 variable determines the output.
# We intiate, dp[0]=nums[0] and dp[1]=max(nums[0],nums[1])
# Then, loop over 2nd element to end of nums array, and assign dp[i] with maximum between robbing current house (nums[i]) and robbing i-2 house and robbing previous house.
# At this point, space complexity is O(n). Later in Method 3, we can achieve the same thing using 2 varaibles - curr and prev. Now, space complexity is O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        #Method 1 - Recursion TLE
    #     return self.helper(nums,0,0)
    # def helper(self,nums,i,robbings):
    #     #base
    #     if i>=len(nums):
    #         return robbings
    #     #logic
    #     case0=self.helper(nums,i+1,robbings) #don't choose
    #     case1=self.helper(nums,i+2,robbings+nums[i]) #choose
        
    #     return max(case0,case1)                            
        
        #Method 2 - DP with 1 D space
        # if len(nums)==0: return 0
        # if len(nums)==1: return nums[0]

        # dp=[0 for _ in range(len(nums))]
        # dp[0]=nums[0]
        # dp[1]=max(nums[0],nums[1])
        # for i in range(2,len(nums)):
        #     dp[i]=max(nums[i]+dp[i-2],dp[i-1])
            
        # return dp[-1]

        #Method 3 - DP with 2 variables
        if len(nums)==0: return 0
        if len(nums)==1: return nums[0]

        prev=nums[0]
        curr=max(nums[0],nums[1])
        for i in range(2,len(nums)):
            temp=curr
            curr=max(nums[i]+prev,curr)
            prev=temp
        return curr



        
