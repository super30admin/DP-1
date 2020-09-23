# Time Coplexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode 

class Solution:
    
    def recurse(self, nums, start):
        curr_max = 0
        for i in range(start, len(nums)):
            if i in self.m:
                curr = self.m[i]
            else:
                curr = nums[i]
                

                if i < len(nums) - 2:
                    val = self.recurse(nums, i + 2)
                    curr += val
                    
                self.m[i] = curr
            
            curr_max = max(curr_max, curr)
        # print(nums, curr_max, self.m)
        
        return curr_max
            
            
            
        
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        self.m = {}
        
        return self.recurse(nums, 0)
        
        