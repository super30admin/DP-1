#Time Complexity: O(N), where N is the length of nums list
#Space Complexity: O(N), where N is the length of the nums list

#CODE:
class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == [] or len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        dp = [0 for _ in range(len(nums))]
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1],nums[i]+dp[i-2])
        return dp[-1]

        # Space complexity: O(1) if we use two variables case

        # if nums == [] or len(nums) == 0:
        #     return 0
        # if len(nums) == 1:
        #     return nums[0]
        # ch = nums[0]
        # nc = max(nums[0],nums[1])
        # for i in range(2, len(nums)):
        #     temp = ch
        #     ch = nc
        #     nc = max(ch, nums[i]+temp)   
        # return nc
        