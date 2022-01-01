# Time Complexity : O(n) n is number of houses 
# Space Complexity : O(1) just using variables to store the skip take values 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : Followed approach from the class 
#house Robber 
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:return nums[0]
        skip = nums[0]
        take = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            temp = max(nums[i] + skip, take)
            skip = take
            take = temp
        return take
        