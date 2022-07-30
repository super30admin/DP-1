'''
Time Complexity - O(n) where n is length of house
Space Complexity = O(1)  
'''


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        prev = nums[0]
        curr = max(nums[0], nums[1])
        for i in range(2, n):
            temp = curr
            curr = max(curr, nums[i]+prev)
            prev = temp
        return curr
