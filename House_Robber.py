class Solution:
    def rob(self, nums: List[int]) -> int:
        
        # Bottom up approach
        skip, pick = 0, nums[0]
        
        for i in range(1, len(nums)):
            
            temp = skip
            skip = max(skip, pick)
            pick = temp + nums[i]
        
        return max(skip, pick)


### Complexity Analysis

# Time Complexity: O(N) --> Iterating through all elements of array
# Space Complexity: O(1) --> Storing only previous two values in two variables.