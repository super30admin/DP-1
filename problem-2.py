#tc: O(n)
#sc: O(n)

class Solution:
    def rob(self, nums) -> int:
        dp = [None] * (len(nums)+1)
        dp[len(dp)-1] = 0 # Nothing to rob
        dp[len(dp)-2] = nums[len(nums)-1] # max of last e in nums with 0 which is ofcourse e
        for i in range(len(dp)-3,-1,-1):
            # max(not choosing which is its next e in dp and choosing which is nums of itself + next to next e in dp)
            dp[i] = max(dp[i+1], dp[i+2]+nums[i])
        
        return dp[0]

obj = Solution()
print(obj.rob([1,2,3,1]))