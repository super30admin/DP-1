#Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


# Your code here along with comments explaining your approach
'''
Thoughts: 
- For intuition, imagine you are walking from one house to the next house and you are able to see how much money each house have. 
- Then as you walk, calculate the maximum money you can get by comparing the money could get by skipping the current house OR 
- stealing the current house and add that with the total money you (could) get from the previous 2 houses

Approach:
1. Create dp table of length nums
2. Solve the dp base cases for first and second index
3. solve the remaining dp table by using the dp formula from the thoughts above
4. return the last element of the dp table as the answer
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        #base cases
        if len(nums) <= 2: return max(nums)
        
        #create dp table
        dp = [0] * len(nums)
        
        #dp base cases
        dp[0] = nums[0]
        dp[1] = max(nums[1], nums[0])
        
        #solve remaining answer in dp table
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
            
        return dp[-1]
