class Solution:
    def rob(self, nums: List[int]) -> int:
        
        
        if len(nums) == 0:
            return 0
        rob = 0
        no_rob = 0
        
        for num in nums:
            # Storing the no_rob value so that it is not changed
            prev_no_rob = no_rob 
            no_rob = max(rob, no_rob)
            rob = num + prev_no_rob
            
        return max(rob, no_rob)
        # Time Complexity: O(n) where n is the size of the array
        # Space Complexity: O(1)
            