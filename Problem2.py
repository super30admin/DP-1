#Approach1
# Time Complexity :O(n)
# Space Complexity :O(n)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 198

#Approach2
# Time Complexity :O(n)
# Space Complexity :O(1)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 198

# You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
# the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
# it will automatically contact the police if two adjacent houses were broken into on the same night.

# Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
# money you can rob tonight without alerting the police.

# Example 1:
#
# Input: nums = [1,2,3,1]
# Output: 4
# Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
#              Total amount you can rob = 1 + 3 = 4.
# Example 2:
#
# Input: nums = [2,7,9,3,1]
# Output: 12
# Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
#              Total amount you can rob = 2 + 9 + 1 = 12.

def main():
    nums = [1,2,3,1]

    ans1 = rob_approach1(nums)
    ans2 = rob_approach2(nums)
    print(ans1)
    print(ans2)

def rob_approach1(nums):
    # Check for base condition
    if not nums:
        return 0
    n = len(nums)
    m = 2

    # There will be only two columns here to either choose or not choose.
    dp = [[0 for col in range(m)] for row in range(n)]

    # The first row says, obviously if chosent then the value itself or if not chosen than 0
    dp[0][0] = nums[0]
    dp[0][1] = 0

    for i in range(1, n):
        for j in range(0, m):
            # If we are in choose column then obviously we will not choose the prior row and the value will be from prior row second column
            if j == 0:
                # Choose
                dp[i][j] = dp[i - 1][j + 1] + nums[i]
            # Else we will choose the max value from choose and not choose of prior row if we are in Not choose.
            # Not choose
            else:
                dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j])

    # Return the max value of choose or not choose in the final row.
    return max(dp[n - 1][0], dp[n - 1][1])

def rob_approach2(nums):
    # Here we really not need a DP
    # We can use 3 variables namely choose, not choose and temp.
    # Whenever we are choosing that means the value will be the not choose value from top and itself. hence Choose = x + temp
    # Whenever we are not choosing then the value will be max of choosing and not choosing.
    # we have to store the value in temp before updating not choose.
    if not nums:
        return 0

    choose = 0
    notChoose = 0
    for each in nums:
        temp = notChoose
        notChoose = max(choose, notChoose)
        choose = each + temp

    return max(choose, notChoose)


if __name__ == '__main__':
    main()