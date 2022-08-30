'''
198. House Robber

TIME COMPLEXITY: O(N) N is no of houses
SPACE COMPLEXITY: O(1)
LEETCODE: Yes
DIFFICULTIES: Nope, as I have listened the class
'''

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) > 1:
            nums[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            yes = nums[i]+nums[i-2] # current house value + max of i-2 house value
            no = nums[i-1] # max of i-1 house value
            
            nums[i] = max(yes, no)
        
        return nums[len(nums)-1]
