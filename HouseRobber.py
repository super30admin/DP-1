"""
Time Complexity: O(N)
Space Complexity: O(1)
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        N = len(nums)
        
        rob_next_plus_one = 0
        rob_next = nums[N - 1]
        
        # DP table calculations.
        for i in range(N - 2, -1, -1):
            
            # Same as recursive solution.
            current = max(rob_next , rob_next_plus_one + nums[i])
            
            # Update the variables
            rob_next_plus_one = rob_next
            print("Index: ", i)
            print("Rob next plus one: ", rob_next_plus_one)
            
            rob_next = current
            print("Rob Next: ",rob_next)
            print("_________")
            
        return rob_next