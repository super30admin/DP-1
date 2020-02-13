# Time Complexity: O (n)(Where n is length of list) 
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - This can be solved in two ways recursivly or dynamicly.
# - In dynamic solution take dp array of input size. At every house take max from either previous house or current house plus second previous house.
# - In recursive solution make function to take index of current house and total value. We will call this function recursively for next house or current house plus second next house. Take max of it and return it.
    
class Solution:
    def rob(self, nums: List[int]) -> int:
        # Dynamic Solution
        l = len(nums)
#       Cover edge cases
        if not l:
            return 0
        if l == 1:
            return nums[0]
#       initialize arr for storign dp values.
        arr = [0] * l
        
#       Setup value of first two element manually.
        arr[0] = nums[0]
        arr[1] = max(nums[0], nums[1])
        
#       Run for loop from third element. Compare the previous sum with current sum plus previous previous sum and chose max from it.
        for i in range(2, l):
            arr[i] = max(nums[i] + arr[i-2], arr[i-1])
            
        return arr[-1]

# Recursive
#         data = [-1] * len(nums)
#         return self.helper(nums, 0, data)
        
#     def helper(self, nums, ind, data):
#         if ind >= len(nums):
#             return 0
#         if data[ind] != -1:
#             return data[ind]
        
#         result = max(nums[ind] + self.helper(nums, ind + 2, data), self.helper(nums, ind +1, data))
#         data[ind] = result
#         return result
