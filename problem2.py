"""
Time Complexity: O(n)  where n is number of houses
Space Complexity: O(n) where n is number of houses

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:

1. Greedy approach: 
Greedy approach does not work for the follwoing example: [2,8,9,2,1,7]
So selecting the maximum 9 we have to select 2,9,1 -> Total Earnings = 12
Ideal Solution: 8,2,7 -> Total Earnings: 17

2. From the Greedy approach we can conclude that all the possibilities should check before coming to any conclusion.
But the Exhaustive approach's Time complexity is exponentioal 2^n hence we can use DP

3. Dynamic Programming:

This problem has only one deciding factor/constraint and that is the amount present in the house which can be robbed.
Let's take an example: [2,7,9,3,1]

    Amount | Not      | Chosen |
           |Chosen (0)|  (Rob) |

     2     |    0      |    2   |
     7     |    2      |    7   |
     9     |    7      |    11  |
     3     |   11      |   10   |
     1     |   11      |   12   |

return dp[rows][cols]
    
"""
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        dp = [[ 0 for col in range(0,2)] for row in range(0, len(nums))]
        dp[0][1] = nums[0]
        
        for i in range(1, len(nums)):
            #Not chosen
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            
            #Chosen
            dp[i][1] = dp[i-1][0] + nums[i]
        
        return max(dp[len(nums)-1][0], dp[len(nums)-1][1])
        
        
