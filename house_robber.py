"""
time - o(n)
space - o(n)
create a list and add whether to rob or not to rob (what is the amount made for each decision)
when we calculate the value for robbing a house, we take previous index's not to rob value
and add the value.
if we choose not to rob, we look at what's maximum in the previous index, 
finally the last index has the max value we can rob
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        robbed=[]
        for i in range(len(nums)):
            if not robbed:
                robbed.append((nums[i],0)) #(choose_t0_rob,choose_not_to_rob)
            else:
                choose_to_rob=nums[i] + robbed[i-1][1]
                choose_not_to_rob = max(robbed[i-1][1],robbed[i-1][0])
                robbed.append((choose_to_rob,choose_not_to_rob))
        return max(robbed[-1])