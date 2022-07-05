# Time Complexity = O(n)
# Space Complexity = O(1), since we are storing values in variables

class Solution:
    def rob(self, nums: list[int]) -> int:
        if len(nums) == 0:
            return 0
        
        # Initialise two variables, one with 0, and the other with the first element of array
        # Doing this method because our next result only depends upon the previous 2 results and not the complete array
        skip = 0
        take = nums[0]
        
        # Iterating from 1, since 0th element already initialised above
        for i in range(1, len(nums)):
            temp = skip                 # Storing the value of skip, as that will be used for the    next iteration
            skip = max(skip, take)
            take = temp + nums[i]
        
        return max(skip, take)

        