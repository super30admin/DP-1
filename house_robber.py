class Solution(object):
    '''
    Recursive
    Time complexity: Exponential
    '''
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.robs(nums, len(nums) - 1)
    
    def robs(self, nums, i):
        if i < 0:
            return 0
        return max(self.robs(nums, i - 2) + nums[i], self.robs(nums, i - 1))
    
    '''
    ** Top-down apprach **
    Time complexity: O(n)
    Space complexity: O(n)
    
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.memo = [-1] * (len(nums) + 1)
        print(self.memo)
        return self.robs(nums, len(nums) - 1)
    
    def robs(self, nums, i):
        if i < 0:
            return 0
        if self.memo[i] >= 0:
            return self.memo[i]
        
        result = max(self.robs(nums, i - 2) + nums[i], self.robs(nums, i - 1))
        self.memo[i] = result
        return result


    ** Bottom-up approch **
    Time complexity: O(n)
    Space complexity: O(n)
    
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        self.memo = [-1] * (len(nums) + 1)
        self.memo[0] = 0
        self.memo[1] = nums[0]
        print(self.memo)
        for i in range(1, len(nums)):
            self.memo[i+1] = max(self.memo[i - 1] + nums[i], self.memo[i])
        return self.memo[len(nums)]
    '''