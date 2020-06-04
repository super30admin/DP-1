# Time Complexity : Add - O(2^n)
# Space Complexity :O(log n)
# Did this code successfully run on Leetcode : No. It was a brute force technique so time exceeded.

# Any problem you faced while coding this : A little bit, I am weak in Recursion

'''
1. I have used a Brute Force Approach for solving the problem.
2. At any point we have 2 cases - Either the Robber Robs the house or he doesn't.
3. If he does, he looks out for index+2 house, and amount get added by nums[index]
4. If he doesn't, he looks for index+1 house and amount remains same
'''


class Solution:
    def rob(self, nums):
        if nums == [] or len(nums) < 1:
            return 0
        
        return self.helper(nums, 0, 0)
            
  
    def helper(self, nums, max_, index):
        
        if index > len(nums)-1:
            return max_
        
        # print("index",index)
        case1 = self.helper(nums, max_ + nums[index], index+2)
        case2 = self.helper(nums, max_, index+1)
        
        return max(case1, case2)
        