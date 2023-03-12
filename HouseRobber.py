class Solution:
    # TC: O(n), SC: O(1)
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 2: return nums[0]
        prev = nums[0]
        curr = max(nums[1], prev)
        for i in range(2,n):
            temp = curr
            curr = max(temp, nums[i]+prev)
            prev = temp
        return curr