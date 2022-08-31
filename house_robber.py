'''
Approach: Recursion
TC: O(2^n); n=number of given houses=len(nums)
SC: O(1)
'''

''' 
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]

        return self.helper(nums, 0)
    def helper(self, nums, ind):
        if ind>=len(nums):
            return 0
        choose = nums[ind] + self.helper(nums, ind+2)
        not_choose = self.helper(nums, ind+1)
        return max(choose, not_choose)
'''

'''
Approach: DP
TC: O(n)
SC: O(1)
'''


class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0] * (len(nums) + 2)

        for i in range(2, len(nums) + 2):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 2])
            # print(dp)
        return dp[-1]

