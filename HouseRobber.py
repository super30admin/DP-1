# time complexity: O(n)
# space complexity: O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        elif len(nums) == 1:
            return nums[0]
        
        # Create a list to store the maximum amount of money that can be robbed at each house
        dp = [0] * len(nums)
        
        # Initialize the first two values in the list
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        # Calculate the maximum amount of money that can be robbed at each house
        for i in range(2, len(nums)):
            dp[i] = max(nums[i] + dp[i-2], dp[i-1])
        
        # Return the maximum amount of money that can be robbed from the last house
        return dp[-1]
