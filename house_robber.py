#O(n) time and O(1) space where n is length of nums
# passed all test cases
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        sum_one = nums[0]
        sum_two = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            num = nums[i]
            current_sum = max(sum_one+num,sum_two)
            sum_one = sum_two
            sum_two = current_sum
        return sum_two