#greedy fails so explore exhaustive approach
#recursive solution

from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        #recursive solution
        def helper(nums, idx):

            #base case
            if idx >= len(nums): #> because we are doing idx+2
                return 0

            #not choose coin
            case1 = helper(nums, idx+1) #go to next house idx+1

            #choose a coin, we have profit
            case2 = nums[idx]+helper(nums, idx+2) #rob alternate house which is idx+2

            return max(case1, case2)

        result = helper(nums, 0)
        return result

#Time Complexity: exponential O(2^n)
#Space Complexity: O(n) n is no of houses.

#DP approach 
class Solution:
    def rob(self, nums: List[int]) -> int:

        if not nums:
            return 0

        if len(nums) == 1:
            return nums[0]
        
        dp = [0] * len(nums) #initialize a 1D array

        #instead of having a dummy index we can do below
        dp[0] = nums[0]
        dp[1] = max(dp[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i-1], nums[i]+dp[i-2]) #here we add corresponding profit and take dp two steps back to avoid adj houses.

        return dp[len(nums)-1]

# Time Complexity : O(N)
# Space Complexity : O(N)


#Using just 2 variables
class Solution:
    def rob(self, nums: List[int]) -> int:

        if not nums:
            return 0

        if len(nums) == 1:
            return nums[0]

        #instead of having a dummy index we can do below
        prev = nums[0]
        curr = max(prev, nums[1])

        for i in range(2, len(nums)):
            temp = curr
            curr = max(curr, nums[i]+prev) #here we add corresponding profit and take dp two steps back to avoid adj houses.
            prev = temp

        return curr

# Time Complexity : O(N)
# Space Complexity : O(1)