class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
# Time Complexity: O(n)
# Space Complexity: O(n)

        # n= len(nums)
        # dp = [[0 for x in range (2)] for x in range (n)]
        # dp[0][0] = 0 # skip the value
        # dp[0][1] = nums[0] # take the value

        # for i in range (1, n):
        #     dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        #     dp[i][1] = dp[i-1][0] + nums[i]
        
        # return max(dp[n-1][0], dp[n-1][1])

# Time Complexity: O(n)
# Space Complexity: O(1)

        n= len(nums)
        dp = [[0 for x in range (n)]
        skip = 0 # skip the value
        take = nums[0] # take the value

        for i in range (1, n):
            temp = skip
            skip = max(skip, take)
            take = temp + nums[i]
        
        return max(skip, take)
