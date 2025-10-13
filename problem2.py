#tc =O(n) sc=O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev2 = nums[0]
        prev1 = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            curr = max(prev1, nums[i] + prev2)
            prev2 = prev1 
            prev1 = curr

        return prev1
