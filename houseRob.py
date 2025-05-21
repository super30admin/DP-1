"""
Apply DP to store the max money robbed. dp[0] = nums[0] (only 1st house), and dp[1] = best of first two nums[0],nums[1].
For each house, check: rob it and add to dp[i-2] or move on and take dp[i-1].
Return dp[-1], which has max robbed amount from all houses
"""
"""
Time Complexity: O(n) - Each house passed once
Space Complexity: O(n) -  dp array of size n
"""
class houseRob:
    def rob(self, nums: list[int]) -> int:
        
        if not nums: return 0
        if len(nums) == 1: return nums[0]
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        
        return dp[-1]

if __name__=="__main__":
    nums = [2,7,9,3,1]
    obj = houseRob()
    print(obj.rob(nums))

        