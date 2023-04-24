// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*

Approach: we consider an optimized approach using tabulation where we compute the "profit" incrementally considering each house one by one. For each house, we calculate the profile if we choose it vs if we don't choose it. In case we choose a house, we cannot choose the house adjacent to it, so we ignore the house before it in the tabulation. In case we don't choose the house, we choose the maximum profit from until the previous house (i.e., max profile between the choose/don't choose cases).

*/

package main

import "math"

func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	dp := make([][2]int, len(nums))

	// initial case - only 1 house exists
	dp[0][0] = 0       // if we don't choose, profit is 0
	dp[0][1] = nums[0] // if we choose, profit is that house's profit

	for i := 1; i < len(nums); i++ {
		// choose the house to rob
		dp[i][0] = int(math.Max( // we need to maximise
			float64(dp[i-1][0]), // previous house was chosen
			float64(dp[i-1][1]), // previous house was not chosen
		))

		// don't choose the house to rob
		// i.e., don't select previous house also
		dp[i][1] = nums[i] + dp[i-1][0]
	}

	// finally return maximum "profit"
	return int(math.Max(
		float64(dp[len(nums)-1][0]),
		float64(dp[len(nums)-1][1]),
	))
}
