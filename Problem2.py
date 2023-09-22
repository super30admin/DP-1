'''
Method 1: Recursion
- Time Complexity: O(2^n) 
- Space Complexity: O(n)

1. If we choose to rob, we add the amount at that index to the amount robbed so far and move to the second next house.
2. If we choose not to rob, we move to the next house.
3. We return the max of the 2 cases at each house. End case is when we reach the end of the array.

Method 2: DP 
1. Maintain 2 variables skip and take that tell us if we decided to skip or take the house at that index.
2. Use these to compute the max amount robbed at that index. 
3. Return the max of skip and take at the end)

- Time Complexity: O(n)
- Space Complexity: O(1)
'''


# Method 1: Recursion
# class Solution:
    # def rob(self, nums: List[int]) -> int:
#         if  nums== None or len(nums) ==0 :
#             return 0
#         return self.recurse(nums,0,0)
    
#     def recurse(self,nums,index,amountRobbed):

#         # base case
#         if index >= len(nums):
#             return amountRobbed

#         # not choose or 0 case
#         case1 = self.recurse(nums,index+1,amountRobbed)

#         # Choose or 1 case
#         case2 = self.recurse(nums,index+2,amountRobbed+nums[index])

#         return max(case1,case2)

# Method 2: DP
class Solution:
    def rob(self,nums: List[int]) -> int:
        if  nums== None or len(nums) ==0 :
            return 0
        
        n = len(nums)
        skip = 0
        take = nums[0]

        for i in range(1,n):
            temp = skip
            skip = max(skip,take)
            take = temp + nums[i]

        return max(skip,take)
