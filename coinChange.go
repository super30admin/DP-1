// Time Complexity : O(mn) where m is number of coins and n is the amount
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some problems with intuitively
//   writing the Infinity value, but figured it out eventually

/*
Approach: we use a tabulation method to solve the problem. The factors
governing the solution are the number of coins left in each path we take
(either choosing or not choosing a particular coin), and the remaining amount
at that path (depending on whether we choose that coin). This is tabulated in
order to store the previous sub-problems (sub-paths) of choosing/not choosing a
particular coin.
*/

package main

import "math"

func coinChange(coins []int, amount int) int {
	if len(coins) == 0 {
		return -1
	}
	if amount == 0 {
		return 0
	}

	// create table for storing sub-problem answers
	dp := make([][]int, len(coins)+1)
	for i := range dp {
		dp[i] = make([]int, amount+1)
	}

	// initialize the table with default values for 0 coins and 0 amount
	for i := 0; i <= len(coins); i++ { // amount 0 (1st column)
		// don't need any coins to make amount 0
		dp[i][0] = 0
	}

	for j := 1; j <= amount; j++ { // coin denomination 0 (1st row)
		// treat this as infinity since ans will never go above amount
		dp[0][j] = amount + 1
	}

	for i := 1; i <= len(coins); i++ { // for all coins
		for j := 1; j <= amount; j++ { // for all amounts
			if coins[i-1] > j {
				// in this case, this coin can never make that amount
				// so select previous ans
				dp[i][j] = dp[i-1][j]
			} else if coins[i-1] == j {
				dp[i][j] = 1 // only 1 coin needed
			} else {
				// take one of 2 "paths"
				dp[i][j] = int(math.Min(
					float64(dp[i-1][j]),            // "don't choose the coin"
					float64(dp[i][j-coins[i-1]]+1), // "choose the coin"
				))
			}
		}
	}

	// if final ans is infinity, didn't find answer
	if dp[len(coins)][amount] > amount {
		return -1
	}

	return dp[len(coins)][amount]
}
