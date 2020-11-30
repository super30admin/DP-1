'''
Time complexity: O(N)
Space complexity: O(1)
'''

class Solution:
    def rob(self, nums) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        dp = [0] *len(nums)
        
        dp[0] = nums[0]
        dp [1] = max(nums[0],nums[1])
        
        for i in range(2,len(nums)):
            dp[i] = max(dp[i - 1],nums[i]+dp[i-2])
            
        return dp[-1]

s = Solution()
print(s.rob([1,2,3,1]))