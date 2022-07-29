# Time complexity : O(n) --> n is the number of elements in the list
# Space : O(n) --> n is the number of elements in the list
# Leetcode : Solved and submitted

class Solution:
    def rob(self, nums: List[int]) -> int:
        # check if the length of the list is 0, if so then return 0
        if len(nums) == 0:
            return 0
        
        # find length of the list, if there is only one element then we return itself as that would be the maximum amount
        n = len(nums)
        if n == 1:
            return nums[0]
         
        # creating an array to store the maximum amount at any point
        dp = [0 for i in range(n)]
        
        # fillinf out the array with the first two elements for which we have the maximum amount that can be robbed
        dp[0] = nums[0]
        dp[1] = max(nums[0],nums[1])
        
        # we traverse from 2nd index as we already have the first two elements and then check which elements could give us the max amount as we can't
        # take the successive index, so we check for the max amount with the next index or index + 2 and adding the amount at that place as well.
        for i in range(2,n):
            dp[i] = max(dp[i-1], nums[i]+ dp[i-2])
        
        # Last element would have the max sum, so returning that value
        return dp[n-1]
