# 198. House Robber

# code:

class Solution:
    def rob(self, nums: List[int]) -> int:
        # Base cases
        if len(nums)==1:
            return nums[0]
        if not nums:
            return 0
        
        # Initializing the variables
        ch = 0
        dch = 0
        prevch = 0
        prevdch = 0
        
        # Logic: At each index we have two options: 
        # to choose or not to choose the value.
        # If we choose: we write prevdontchoose val + current val 
        # If we dont choose: we take the max(prevchose and prevdontchoose)
        for i in range(1, len(nums)+1):
            prevch = ch
            prevdch = dch
            ch = prevdch + nums[i-1]
            dch = max(prevch, prevdch)
            
        
        return max(ch,dch)
        
# Time Complexity: O(N)
# Space Complexity: O(1)
# Accepted on Leetcode: YES
# Any problems faced: No.