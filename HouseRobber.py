# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class OneDimDynamic:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(1, len(nums)):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]) #Steal current house or keep previously stolen house
        
        return dp[-1]

# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class ConstantTimeDp:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        prev2prev = nums[0] #Only need i - 2 and i - 1 at each step. Hence, use variables.
        prev = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            temp = max(prev2prev + nums[i], prev)
            prev2prev = prev
            prev = temp
        
        return prev