class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        dp = []
        dp.append(nums[0])
        if len(nums) == 1:
            return nums[0]
        dp.append(max(nums[0],nums[1]))
        for i in range(2,len(nums)):
            dp.append(max(dp[i-1],nums[i]+dp[i-2]))
        return dp[len(nums)-1]


#Time Complexity :O(n) where n is the the total number of houses
#Space Complexity :O(n) where n is th total number of houses