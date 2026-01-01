class Solution:
    def rob(self, nums: List[int]) -> int:
        prev1 = 0
        prev2 = 0  

        for x in nums:
            temp = prev1
            prev1 = max(prev1, prev2 + x)
            prev2 = temp

        return prev1