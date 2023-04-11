class Solution:
    def rob(self, nums: List[int]) -> int:
        a = 0
        b = 0
        for i in range(len(nums)):
            x = max(b,a + nums[i])
            a = b
            b = x
        return b
        