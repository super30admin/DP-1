# Approach 2: Exhaustive approach - iterative DP solution

"""
Description:
We need to build a table for exhaustive approach, e.g.:

1  1
2  2
3  max(3+1,2) = 4  
1  max(1+2,4) = 4  
so we take max(nums[i]+dp[i-2], dp[i-1]) - and the DP array is our reference table

Another example:

2  2
7  7
9  max(9+2,7) = 11
3  max(3+7, 11) = 11
1  max(11+1, 11) = 12

Solution TC O(n) for 1 iteration over the array and SC O(n) for DP array

"""
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if len(nums) == 1:
#             return nums[0]
#         elif len(nums) == 2:
#             return max(nums[0], nums[1])
#         dp = [nums[0], max(nums[0],nums[1])]  #. at 0th index, just select nums[0], at 1st index choose max of 0th and 1st index
#         for i in range(2,len(nums)):
#             dp.append(max(nums[i]+dp[i-2], dp[i-1]))

#         return dp[-1]

"""Approach 3:
Remove usage of DP array as we only need last two items in the array anyways. SC O(1) and TC O(n)


"""
    
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         if len(nums) == 1:
#             return nums[0]
#         elif len(nums) == 2:
#             return max(nums[0], nums[1])
#         dp0 = nums[0]
#         dp1 = max(dp0,0+nums[1])  # at 0th index, just select nums[0], at 1st index choose max of 0th and 1st index
#         robbed = set()
#         for i in range(2,len(nums)):
#             # print(nums[i], dp1, nums[i], "+",dp0)
#             if i == 2:
#                 if dp1 < nums[i] + dp0:
#                     robbed.add(nums[i-2])
#             if dp1 < nums[i] + dp0 and nums[i-1] not in robbed:
#                 robbed.add(nums[i])
#             elif nums[i-2] not in robbed:
#                 robbed.add(nums[i-1])
#             dp1, dp0 = max(nums[i]+dp0, dp1), dp1
#         print(robbed)
#         return dp1



"""Approach 4:
Remove usage of DP array as we only need last two items in the array anyways. SC O(n) for robbed houses and TC O(n)
If we split the decision to rob or not to rob in 2 columns, it looks like this
   0      1
2  0      2
7  2      7+0
9  7      9+2
3  11     7+3
1  11     11+1   
Using this we can decide which houses we robbed and add them to set() of houses we robbed
see comments below
"""
    
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return max(nums[0], nums[1])
        dp0 = nums[0]
        dp1 = max(dp0,0+nums[1])  # at 0th index, just select nums[0], at 1st index choose max of 0th and 1st index
        robbed = set()
        for i in range(2,len(nums)):
            print(nums[i], dp1, nums[i], "+",dp0)
            if i == 2:
                """   # when we are on 2nd index, we can tell if we robbed 1st house or second
                       0      1
                    2  0      2
                    7  2      7+0
                    9  7      9+2 Here as we can see dp1(7) is less than dp0+nums[i], so that means we robbed current house and i-2th house
                    add i-2 to robbed
                    else i-1
                """                
                if dp1 <= nums[i] + dp0:
                    robbed.add(i-2)
                else:
                    robbed.add(i-1)
            """
            Here on we check if value we got from robbing previous house dp1, is greater than or less than value robbing current house + not robbing previous
            if former is true, add i-1 to the robber(provided we didn't robe i-2th house) else add current house index i
            """
            if dp1 < nums[i] + dp0 and i-1 not in robbed:
                robbed.add(i)
            elif i-2 not in robbed:
                robbed.add(i-1)
            dp1, dp0 = max(nums[i]+dp0, dp1), dp1
        # print nums[i] for every house index we marked as robbed
        print([nums[i] for i in robbed])
        return dp1

    
    
# Approach 1: Recursive Exhaustive DP solution. Runs into time limit exceeded on large inputs.
# class Solution:
#     def rob(self, nums: List[int]) -> int:
#         return self.helper(nums,0, 0)
    
#     def helper(self, nums, index, amount):
#         if index >= len(nums):
#             return amount
#         return max(
#             self.helper(nums,index+2, amount+nums[index]),
#             self.helper(nums,index+1, amount)q
#         )