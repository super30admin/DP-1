class Solution(object):
    def rob(self, nums):
        """
        Time complexity: O(n)
        Space complexity: O(1)
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n < 2:
            return nums[0]

        # Base cases
        prev = nums[0]  # Maximum rob amount for the first house
        # Maximum rob amount for the first two houses
        curr = max(nums[0], nums[1])

        # Calculating maximum rob amount for each house
        for i in range(2, n):
            # Store the current maximum amount temporarily
            temp = curr
            # Choose the maximum amount between robbing the current house and not robbing it,
            # considering the previous maximum amount and the current house value
            curr = max(curr, nums[i] + prev)
            # Update the previous maximum amount for the next iteration
            prev = temp

        return curr
