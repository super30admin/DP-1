# TC: O(n)
# SC: O(1)
# LC: yes

class Solution:
    def rob(self, nums: List[int]) -> int:
        for i in range(1,len(nums)):
            if i == 1:
                nums[i] = max(nums[i], nums[i-1])
            else:   
                nums[i] = max(nums[i-2]+nums[i], nums[i-1])
        return nums[-1]
#         currmax = 0
#         table = [[0 for i in range(2)] for i in range(len(nums))]
#         table[0] = [0,nums[0]]
#         for i in range(1,len(table)):
#             table[i][0] = max(table[i-1])
#             table[i][1] = table[i][0] + nums[i]
        
#         print(table)
#         return max(table[-1])
            

#         def helper(nums, amount, index):
#             #base case
#             if index >= len(nums): return amount
#             # choose 
#             a = helper(nums, amount+nums[index], index+2)
#             # not choose
#             b = helper(nums, amount, index+1)
#             # print(a,b)
#             return max(a,b)
#         return helper(nums, 0, 0)

        