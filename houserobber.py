#  Time Complexity : O(n)
# Space Complexity :O(n)
# Leet Code: Yes

class Solution:
    def rob(self, nums: List[int]) -> int:

        if len(nums) == 0:
            return 0

        amount = []
        amount.append(nums[0])
        
        n = len(nums)
        if n<2:
            amount.append(nums[0])
        
        for i in range(1, n):
            if i == 1:
                amount.append(max(amount[i-1],nums[1]))
            else:
                amount.append(max(amount[i-1], nums[i]+amount[i-2]))

        return amount[n-1] 