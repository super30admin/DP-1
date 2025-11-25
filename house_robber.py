class Solution:
    def rob(self, nums: List[int]) -> int:
        # Initialize a cache to store results
        self.cache = {}
        # Start the process from the first house (index 0)
        return self.helper(nums, 0)

    def helper(self, nums, idx):
        # Base Case: If we've gone past the last house, we can't rob any more money.
        if idx >= len(nums):
            return 0

        # Memoization: If we already calculated the max amount for this index, return it.
        if idx in self.cache:
            return self.cache[idx]
        
        # Choice 1: Do not rob the current house
        notRobbed = self.helper(nums, idx + 1) # Move to the next house

        # Choice 2: Rob the current house
        # Add the current house's money and move two houses ahead (skipping the next one)
        robbed = nums[idx] + self.helper(nums, idx + 2) 

        # The maximum amount is the better of the two choices
        maxAmount = max(robbed, notRobbed)

        # Store the result in the cache before returning
        self.cache[idx] = maxAmount
        return maxAmount
