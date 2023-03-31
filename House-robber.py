#TC: O(n)
#SC: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:

        dp = [0,nums[0]]

        for rob in range(1,len(nums)):
            #temp = dp[0] + nums[rob]
            dp = [max(dp),dp[0] + nums[rob]]
            print(dp)

        return max(dp)    

