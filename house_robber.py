# Time Complexity - O(n)
# Space Complexity - O(n)

class Solution:
    
    def rob(self, nums: List[int]) -> int:
        dp = [[0 for j in range(2)] for i in range(len(nums))]
        dp[0][0] = 0
        dp[0][1] = nums[0]
        for i in range(1,len(dp)):
            # not choosing
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            # choosing
            dp[i][1] = dp[i-1][0]+nums[i]
        result = max(dp[-1][0],dp[-1][1])
        
        # houses robbed to get loot maximum money
        houses = []
        for i in range(len(dp)-1,-1,-1):
            if dp[i][1]==result:
                houses.append(nums[i])
                result = result-nums[i]
        return sum(houses)
