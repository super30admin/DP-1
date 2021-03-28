class Solution(object):
    def __init__(self):
        self.mem = {}
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # At every point you have two options pick the number or not. If you pick you cannot pick the next number
        # Brute Force has a Time complexity O(n!) as we are considering all the combinations of list
        """
        if(len(nums) <=2 ):
            return max(nums)
        return max(nums[0]+self.rob(nums[2:]),self.rob(nums[1:]))
        """
        
        # Solution using Memoization, Top Down approach, storing the output of each computation in memory
        # Time Complexity is O(n) and Space Complexity is O(1)
        out = self.robHouse(nums,0)
        return out
        
    def robHouse(self,nums,i):
        if i in self.mem:
            return self.mem[i]
        l = len(nums)
        if(len(nums[i:l]) <= 2):
            return max(nums[i:l])
        else:
            self.mem[i] = max(nums[i] + self.robHouse(nums,i+2),self.robHouse(nums,i+1))
            return self.mem[i]