# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)
* Start thinking from greedy approach, then exhaustive for finding all combination, then find DP pattern, then decide deciding fact, that will be DS for dp tabulization
* if denomination > amount
* else Math.min(Case 0, case 1) //case0, case1(1 for choosing that coin + its value is in same row & denamination step back)

## Problem2 (https://leetcode.com/problems/house-robber/)
* 2 adjacent homes cannot be robbed on same night.
* 2 greedy approach - alternate house, start from maximum element
* only 1 deciding factor - 1-D array in dp, amount is not the deciding factor
* assign value for first 2 element, then dp[i] of that element is max of prev dp[i-1] & summation of that element with earlier dp[i-2]

