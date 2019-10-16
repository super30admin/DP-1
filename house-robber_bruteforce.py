class Solution:
    def rob(self, nums: List[int]) -> int:
        max_amnt = 0
        while len(nums)>0:
            if len(nums) == 1:
                max_amnt = nums[0]
            elif len(nums) == 2:
                max_amnt = max(nums)
            else:
                max_amnt = max_amnt + max(nums)
                max_indx = nums.index(max_amnt)
                if max_indx != len(nums)-1:
                    nums.pop(max_indx+1)
                if max_indx != 0:
                    nums.pop(max_indx-1)
                nums.pop(max_indx-1)
        return max_amnt