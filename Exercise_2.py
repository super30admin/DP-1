# Time Complexity  : O(n) where n = len(nums)
# Space Complexity : O(1) auxiliary
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues


from typing import List

class Solution:

    def rob(self, nums: List[int]) -> int:

        #Space Optimization

        prev1 = 0 # dp[i-1]
        prev2 = 0 # dp[i-2]

        for i in nums:
            curr = max(prev1, prev2 + i)
            prev2 = prev1
            prev1 = curr

        return prev1

#---------------------------------------------------------------------
        #Tabulation

        # n =  len(nums)

        # if n == 0:
        #     return 0

        # dp = [0] * (n+1)
        # dp[0] = 0
        # dp [1] = nums[0]

        # for i in range(2, n + 1):
        #     dp[i] = max(dp[i-1], dp[i-2] + nums[i-1])

        # return dp[n]

#---------------------------------------------------------------------
        
        # Memoization
        # n = len(nums)
        # memo = [-1] * (n+1)

        # def helper(i):
        #     if i >= n:
        #         return 0
            
        #     if memo[i] != -1:
        #         return memo[i]
            
        #     memo[i] = max(nums[i] + helper(i + 2), helper(i + 1))
        #     return memo[i]

        # return helper(0)

#---------------------------------------------------------------------

        #Recursive way
        # n = len(nums)

        # def helper(i):

        #     if i >= n:
        #         return 0
            
        #     return max(nums[i] + helper(i + 2), helper(i + 1))

        # return helper(0)
#---------------------------------------------------------------------


if __name__ == "__main__":
    sol = Solution()

     # Example 1
    print(sol.rob([1, 2, 3, 1]))   # expected 4

    # Example 2
    print(sol.rob([2, 7, 9, 3, 1]))  # expected 12

    # Additional tests
    print(sol.rob([]))             # expected 0
    print(sol.rob([5]))            # expected 5
    print(sol.rob([2,1,1,2]))      # expected 4