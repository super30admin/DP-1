package main

import (
	"math"
)

/*

Two potential solutions
- one using recursion - time complexity is going to be O(2^N) - ie exponential
- other is going to be O(N)
Trying to do the mXn complexity for this question and will drop in notes later.

// Todo : notes are must here and how we came to conclusion of how to solve this question using a mXn matrix or a DP matrix

*/
// Time : O(mXn) - where m and n are the size of the dp matrix
// Space : O(1) : constant as mXn will always be constant for a given value.
func coinChange(coins []int, amount int) int {
	m := len(coins) + 1 // 3 rows
	n := amount + 1     // 12 columns

	// need a matrix to store answers
	dp := make([][]int, m) //3 rows first
	for i := 0; i < m; i++ {
		//dp[i] = make([]int,m+1)
		dp[i] = make([]int, n)
	}

	for sum := 0; sum < n; sum++ {
		dp[0][sum] = amount + 1
	}

	for coin := 1; coin < m; coin++ { // runs 4 times
		for sum := 1; sum < n; sum++ { // run 11 times - ie until I can make the sum with a given coin
			if sum == 0 {
				// 0 sum needs 0 coin
				continue
			}
			theCoin := coins[coin-1]

			//take coin
			newSum := sum - theCoin
			if newSum >= sum {
				dp[coin][sum] = int(math.Min(float64(dp[coin-1][sum]), float64(dp[coin][sum-theCoin]+1)))
			}

			// dont take coin
			if theCoin > sum {
				dp[coin][sum] = dp[coin-1][sum]
			} else {
				dp[coin][sum] = int(math.Min(float64(dp[coin-1][sum]), float64(dp[coin][sum-theCoin]+1)))
			}
		}
	}

	if dp[m-1][n-1] > amount {
		return -1
	}
	return dp[m-1][n-1]
}
