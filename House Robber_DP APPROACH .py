
# DYNAMIC PROGRAMMING SOLUTION

# Time Complexity: O(m * n), => O(m) as n is small, where m: no of rows in dp matrix and n: no of columns in dp matrix
# Space Complexity: O(m * n), is the size of DP martix
# Did problem run on Leetcode: yes 

class Solution:
    def rob(self, nums):

        # BASE CASE,
        if not nums or len(nums) == 0:
            return 0

        # populating the DP matrix,
        dp = [[0 for i in range(2)] for j in range(len(nums))]
        dp[0][1] = nums[0]
        for i in range(1, len(nums)):
            # Not-Choose the House,
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            # Choose the House,
            dp[i][1] = nums[i] + dp[i-1][0]

        #In the end, we return the max of the last row entries,
        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])

output = Solution()
print(output.rob(nums=[2, 7, 9, 3, 1]))




