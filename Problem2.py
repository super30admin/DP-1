#Time complexity: O(n) where n is the length of input array
#Space complexity: O(1)
#Works on leetcode: yes
#Approach: Since only alternate houses can be robbed, we keep track of sum of alternate amounts using two variables.
# The "last" variable keeps memory of last maximum amount and "cur" keep tracks of the current maximum amount
class Solution:
	#Function to get the maximum amount the house robber can get
    def rob(self, nums: List[int]) -> int:
        last, cur = 0,0
        for n in nums:
            last, cur = cur, max(cur, last+n)
        return cur