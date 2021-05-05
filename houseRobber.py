"""
Intuition: Since it has not possible to rob adjacent houses, for any given house we can either rob it or not rob it.


#####################################################################
For Recursive: 2 decisions are made at every row.
Time Complexity : O(2^N)  N = number of rows
Space Complexity : O(2^N) 
#####################################################################
For DP Approach using skip, previousSkip and take: 
Time Complexity : O(N)  N = number of elements
Space Complexity :  O(1) 
#####################################################################
For DP Approach using N*2 matrix: 
Time Complexity : O(N)  N = number of elements
Space Complexity :  O(2*N)  N = number of elements
#####################################################################
"""

#Recursion
class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.helper(nums, 0, 0)
        
    def helper(self, nums, index, amount):
        
        if index >= len(nums):
            return amount
        else:
            case1 = self.helper(nums, index + 2, amount + nums[index])
            case2 = self.helper(nums, index + 1, amount) 
            print(case1, case2)
            return max(case1, case2)
            
#Using a N*2 matrix to store skip and take
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        dp = [[0 for _ in range(2)] for _ in range(len(nums))]
        print(len(dp))
        dp[0][1] = nums[0]
        for index in range(1, len(nums)):
            num = nums[index]
            dp[index][0] = max(dp[index-1][0],dp[index-1][1])
            dp[index][1] = dp[index-1][0] + num
        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])

#My modified approach. Using a O(N) array to store maximum robbing cost at each index.
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) ==1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[1], nums[0])
        
        maxAmount = [0] * len(nums)
        maxAmount[0] = nums[0]
        maxAmount[1] = max(nums[0], nums[1])
        for index in range(2, len(nums)):
            
            num = nums[index]
            maxAmount[index] = max(num + maxAmount[index-2] ,maxAmount[index-1] )
        
        return maxAmount[-1]

#Using no space
class Solution:
    def rob(self, nums: List[int]) -> int:
        skip = 0
        take = nums[0]
        for index in range(1, len(nums)):
            num = nums[index]
            previousSkip = skip
            skip = max(previousSkip,take)
            take = previousSkip + num
        return max(skip, take)