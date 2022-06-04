# time complexity is o(n), where n is the size of the input
# space complexity is o(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums) == 0):
            return 0
        if(len(nums) == 1):
            return nums[0]
        prev = nums[0]
        curr = max(nums[0], nums[1])
        for i in range(2,len(nums)):
            temp = curr
            curr = max(temp, nums[i]+prev)
            prev = temp
        return curr
            