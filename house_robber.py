"""
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 
"""


def rob(nums):
    # two variables to calculate maximum
    # rob1 is the last house and rob1 is before that
    # Initializing to zero
    rob1, rob2 = 0, 0

    for n in nums:
        # to calculate maximum that we can rob until n
        # [rob1, rob2, n, n+1, ....]
        temp = max(n+rob1, rob2)
        # shift rob1 to next point
        rob1 = rob2
        # shift rob2 to next point
        rob2 = temp

    return rob2
        
# driver code
print(rob([1,2,3,1]))