# Problem2 (https://leetcode.com/problems/house-robber/)
# Time Complexity: O(n),we loop through the houses once, from index 2 to n-1
# Space Complexity: O(1),we only keep two rolling variables, prev and current, no dp array needed
# Approach:
# instead of a dp array, we just keep track of two variables, previous and current max
# for each house, we decide to skip it or rob it, and update our variables accordingly
# skipping means we keep the current best, robbing means we add this house's money to prev
# at the end, current holds the maximum money we can rob

class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)     # total number of houses

        if n == 1:
            return nums[0]
            # edge case, only one house means we just take its money
            # nothing to compare against, so handle separately before the loop

        prev = nums[0]     # best money robbable using only house 0

        current = max(nums[0], nums[1])
        # best money robbable using houses 0 and 1
        # rob house 0 alone, or rob house 1 alone, since adjacent houses can't both be robbed
        # take whichever is bigger

        for i in range(2, n):
            # start from house index 2, since houses 0 and 1 are already handled above

            temp = current
            # save the old current before we overwrite it
            # we need this old value to become the new prev after this step

            current = max(temp, nums[i] + prev)
            # decide: skip house i, keep the best so far (temp)
            # or rob house i, add its money to prev (best total not including house i-1)
            # take whichever gives more money, store as the new current

            prev = temp
            # move prev forward to represent "best up through house i-1"
            # using the saved temp, since current has already advanced to house i

        return current
        # after the loop, current holds the max money robbable using all n houses