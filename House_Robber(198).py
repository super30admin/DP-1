# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0 or nums == None:
            return 0

        # Here we take 2 variables leave and take to simulate a 2d arrary it 0,1 indicating
        # the case when we leave an element or take an element
        leave = 0
        take = nums[0]

        # we go over the array and maintain the leave and take variables
        # for the leave part we can choose the max of the 2 cases above since there is restriciton only if we decide to take an element
        # for the take we choose the last 0(or not taken) case since we can't take adjacent elements
        # and add it to the current element
        for i in range(1, n):
            proxy = leave
            leave = max(take, leave)
            take = proxy + nums[i]

        return max(leave,take)

        # Approach using extra array
#         n = len(nums)
#         if n == 0 or nums == None:
#             return 0

#         final = [[0 for _ in range(2)] for _ in range(n)]
#         final[0][1] = nums[0]

#         for row in range(1,n):
#             for col in range(2):
#                 if col == 0:
#                     final[row][0] = max(final[row-1][0], final[row-1][1])
#                 else:
#                     final[row][1] = final[row-1][0] + nums[row]

#         return max(final[n-1][0], final[n-1][1])