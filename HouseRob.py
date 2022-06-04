Time Complexity: O(n); n is the size of the nums list
Space Complexity: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        prev = nums[0]
        curr = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            temp = curr
            curr = max(curr, nums[i]+prev)
            prev = temp
        
        return curr
