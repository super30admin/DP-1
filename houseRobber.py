#Time: O(n)
# Space: O(1)
#did the code run? yes
#issues faced: index range
#Approach:
# bottom-up DP with space optimisation
# you pick a house or not
# f(n) = max(f(n-1), n+f(n-2))

class Solution:
    def rob(self, nums: List[int]) -> int:
        f = [0, nums[0]]
        for i in range(1, len(nums)):
            f[0], f[1] = f[1], max(f[1], nums[i] + f[0])
        return f[1]