# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def rob(self, nums: List[int]) -> int:
        n=len(nums)
        if n<2:
            return nums[0]
        prev=nums[0]
        curr=max(nums[0],nums[1])
        for i in range(2,len(nums)):
            temp=curr
            curr=max(curr,prev+nums[i])
            prev=temp
        return curr
        
