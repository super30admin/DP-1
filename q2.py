# Time Complexity : O(n), Where n is number of elements in nums
# Space Complexity : O(n), Where n is number of elements in nums
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

from typing import List
class Solution:
    def actualsol(self,index,nums,memo)->int:
        if(index>=len(nums)):
            return 0
        if(memo[index]!=None):
            return memo[index]
        
        #If we decide to not rob
        l= 0+self.actualsol(index+1,nums,memo)
        #If we decide to rob
        r= nums[index]+self.actualsol(index+2,nums,memo)
        memo[index]=max(l,r)
        return max(l,r)
    def rob(self, nums: List[int]) -> int:
        memo=[None for i in range(len(nums))]
        #print(memo)
        ans=self.actualsol(0,nums,memo)
        #print(memo)
        return ans