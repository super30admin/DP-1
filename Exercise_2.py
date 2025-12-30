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
'''
import time
import numpy as np

# def rob_DP(houses, D, i=-2):
#     N = len(houses)
#     # Handle edge case for i = N-2, N-1
#     if N == 1:
#         return houses[0]
#     elif N == 2:
#         return max(houses[0], houses[1])

#     # Code below gets executed for i=-2,-1,0,..,N-3
#     if i < 0:
#         amount = 0
#     else:
#         amount = houses[i]
#     m = 0
#     for j in range(i+2,N):
#         if j not in D:
#             D[j] = rob_DP(houses, D, j)
#         m = max(m, D[j])
#     amount += m
#     D[i] = amount
#     return D[i]

def rob(houses):
    '''
    recursion
    '''
    def recurse(houses, index, loot):
        N = len(houses)

        if index > N-1:
            return loot

        # 0-case (don't loot)
        case_0 = recurse(houses, index+1, loot)

        # 1-case (loot)
        case_1 = recurse(houses, index+2, loot+houses[index])

        return max(case_0, case_1)

    N = len(houses)
    # Handle edge cases
    if N == 0:
        return 0
    if N == 1:
        return houses([0])
    if N == 2:
        return max(houses[0], houses[1])

    return recurse(houses, 0, 0)

def rob_DP(houses):
    '''
    dynamic programming
    '''
    N = len(houses)
    dp = np.zeros(N+1)

    dp[0] = 0
    dp[1] = houses[0]
    for i in range(2, N+1): # O(N)
        case_0 = dp[i-1]
        case_1 = houses[i-1] + dp[i-2]
        dp[i] = max(case_0,  case_1)
    return dp[N]

def run_rob():
    tests = ([2,7,9,3,1], 12), ([1,2,3,1], 4), ([1,2], 2), ([2, 7, 3, 1, 4, 2, 1, 8], 19)
    for test in tests:
        houses, ans = test[0], test[1]
        start = time.time()*1000
        ans_rec = rob(houses)
        elapsed =  time.time()*1000 - start
        print(f"\nhouses = {houses}")
        print(f"Max amt robbed={ans_rec}, time = {elapsed:.2f} ms (recursion)")
        print(f"Pass: {ans == ans_rec}")

    for test in tests:
        houses, ans = test[0], test[1]
        start = time.time()*1000
        ans_dp = rob_DP(houses)
        elapsed =  time.time()*1000 - start
        print(f"\nhouses = {houses}")
        print(f"Max amt robbed={ans_dp}, time = {elapsed:.2f} ms (DP)")
        print(f"Pass: {ans == ans_dp}")

run_rob()
