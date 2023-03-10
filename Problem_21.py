# Time Complexity: O(n) where  n => houses
# Space Complexity: O(1)

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return nums[0]
        dp = [0] * len(nums)
        prev = nums[0]
        curr = max(prev, nums[1]+0)

        for i in range(2, len(nums)):
            temp = curr
            curr = max(curr,  nums[i] + prev)
            prev = temp

        return curr