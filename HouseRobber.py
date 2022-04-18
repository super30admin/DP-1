#timeComplexiety - O(N)
#SpaceComplexiety- O(N)
# yes Successfully accecpted on leetcode
# so far no problem faced

class Solution:
    def rob(self, nums: list[int]) -> int:
        rob1, rob2 = 0, 0

        # [rob1, rob2, n, n+1,....]
        for n in nums:
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp

        return rob2
