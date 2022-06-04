# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==0: return 0
        if len(nums)==1: return nums[0]
        prev_1=0
        prev_2=0
        for i in range(len(nums)):
            val=max(prev_1,nums[i]+prev_2)
            prev_2=prev_1
            prev_1=val
        return prev_1