"""
TC:O(n)
SC:O(n)

"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        dp=[0 for _ in range(len(nums)+1)]
        dp[len(nums)-1]=nums[len(nums)-1]
        for i in range(len(nums)-2,-1,-1):
            dp[i] = max(dp[i+1],dp[i+2]+nums[i])
        max1 = 0
        for i in dp:
            if i > max1:
                max1=i
        return max1