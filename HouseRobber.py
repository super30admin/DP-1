#All test cases on leetcode passed

class Solution:
    def rob(self, nums: List[int]) -> int:

        #Further optimization to reduce space to O(1)
        #Time complexity - O(n)
        #Space complexity - O(1)
        if len(nums)==1:
            return nums[0]

        prev0 = nums[0]
        prev1 = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            cur = max(prev0+nums[i], prev1)
            prev0 = prev1
            prev1 = cur
        
        return prev1




        #Here we use DP approach. If only 1 house then we return the only value. 
        # If 2 houses then we return max of the 2. For further houses we take max(current house val + DP[i-2] or DP[i-1])
        #Time complexity - O(n)
        #Space complexity - O(n)
        if len(nums)==1:
            return nums[0]

        dp = [0]*len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        
        return dp[len(nums)-1]


        