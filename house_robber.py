'''
198 House Robber
https://leetcode.com/problems/house-robber/description/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Example 3:
Input: nums = [1,2]
Output: 2
Explanation: Rob house 2 (money = 2).
Total amount you can rob = 2.

Example 4: (interesting case)
Input: nums = [2, 7, 3, 1, 4, 2, 1, 8]
Output: 19
Explanation: 7 + 4 + 8 = 19

Solution:
1. Brute Force (Recursion): At each house, we have two choices: steal or skip. We do this recursively for each house. Thus for N houses, we have 2^N possibilities.
Time: O(2^N), Space: O(N)

2. Recursion with memoization (top-down approach): We keep a track of the max possible loot at each house using a hash map to avoid computing repeated sub-problems. Since the max loot at every house is computed only once, time complexity is O(N).
Time: O(N), Space: O(N)

3. Tabulation (bottom-up approach):: Construct 1-d DP array of size N+1, where dp[i] = max loot until ith house (i.e. 0,...,i)
Initialize: dp[0] = 0        (since no loot before the 1st house)
            dp[1] = house[0] (max loot until the 1st house)
DP computation:
            dp[2] = max(loot house 2 + prev loot, don't loot house 2 + prev loot)

            if we loot house 2, then we know for sure we must have skipped house 1. That means our prev loot is the max loot until house 0 (dp[0])

            if we don't loot house 2, then we may/may not have looted house 1. That means our prev loot is the max loot until house 1 (dp[1])

            Thus, for any i, dp[i] = max(house[i-1] + dp[i-2], dp[i-1])
Time: O(N), Space: O(N)
https://youtu.be/IsBihs859dU?t=1559 (Technique for filling DP bottom up table using recusion tree diagram)
https://youtu.be/IsBihs859dU?t=2019 (Backtracking bottom up)
https://youtu.be/IsBihs859dU?t=2306 (Technique for filling DP top down table using recusion tree diagram, till 42:00)

'''

def rob(houses):
    '''
    recursion
    '''
    def recurse(houses, index):
        # base
        if index >= N:
            return 0

        # logic
        rob_this = houses[index]

        # don't rob
        case_0 = recurse(houses, index+1)

        # rob
        case_1 = rob_this + recurse(houses, index+2)

        result = max(case_0, case_1)

        return result


    N = len(houses)
    if N == 0:
        return 0
    elif N == 1:
        return houses[0]
    elif N == 2:
        return max(houses[0], houses[1])

    return recurse(houses, 0)


def rob_DP(nums):
    '''
    DP bottom up
    '''
    # works fine, but the index of nums[] is a bit confusing
    # N = len(nums)
    # if N == 0:
    #    return 0
    # dp = [0]*(N+2)
    # for i in range(2, N+2):
    #     dp[i] = max(nums[i-2] + dp[i-2], dp[i-1])
    # return dp[-1]

    # this keeps the index of nums[] quite straight-forward
    N = len(nums)
    if N == 0:
        return 0
    dp = [0]*(N)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for i in range(2, N):
        dp[i] = max(nums[i] + dp[i-2], dp[i-1])
    return dp[-1]

def rob_DP_backtrack(nums):
    '''
    DP bottom up w/ backtracking
    '''
    N = len(nums)
    if N == 0:
        return 0
    dp = [0]*(N)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for i in range(2, N):
        dp[i] = max(nums[i] + dp[i-2], dp[i-1])


    # backtrack
    robbed_houses = []
    i = N - 1

    while i >= 0:
        if i == 0:
            # Only house 0 is left, so it must have been robbed
            robbed_houses.append(i)
            break
        elif i == 1:
            # Choose the house that contributed the maximum value
            if nums[1] > nums[0]:
                robbed_houses.append(1)
            else:
                robbed_houses.append(0)
            break
        elif dp[i] == dp[i-1]:
            # House i was skipped
            i -= 1
        else:
            # House i was robbed
            robbed_houses.append(i)
            i -= 2 # Move past the neighbor

    # Reverse to return indices in chronological order
    return dp[-1], [nums[i] for i in robbed_houses[::-1]]

def run_tests():
    tests = [([2,7,9,3,1], 12),
             ([1,2,3,1], 4),
             ([1,2], 2),
             ([2, 7, 3, 1, 4, 2, 1, 8], 19),
             ([2,1,1,3,5,4], 9),
    ]
    for test in tests:
        houses, ans = test[0], test[1]
        res1 = rob(houses)
        res2 = rob_DP(houses)
        res3, path = rob_DP_backtrack(houses)
        print(f"\nhouses = {houses}")
        print(f"Max amt robbed = {res1} (recursion)")
        print(f"Max amt robbed = {res2} (DP bottom up)")
        print(f"Max amt robbed = {res3} (DP bottom up w/ backtrack)")
        print(f"Path: {path}" )
        passed = (ans == res1 == res2 == res3)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()
