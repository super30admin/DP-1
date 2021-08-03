class Solution:
    """
    REcursion approach
    where we explore all the possible values
    Time limit Exceeds
    TC - O(2^n)
    SC - O(1)
    """

    def approach1(self, nums, index, money):
        if index >= len(nums):
            return money
        none = self.approach1(nums, index + 1, money)
        rob = self.approach1(nums, index + 2, money + nums[index])
        return max(none, rob)

    """
    loop approach.
    variable method where we store the max money in decision variables
    TC - O(n)
    SC - O(1)
    """
    def approach2(self, nums):
        nope, rob, temp = 0, 0, 0
        for i in nums:
            temp = nope + i
            nope = max(nope, rob)
            rob = temp
        return max(nope, rob)

    def rob(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return False
        # return self.approach1(nums,0,0)
        return self.approach2(nums)