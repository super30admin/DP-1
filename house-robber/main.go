package main

import "fmt"

// DP solution

/*

So one of the things that took me for a spin in this question was how to make a decission on how to store the
value at a corresponding step.
- The answer to this was in the question itself : how many decision making elements do we have here?
- We only have one decision-making element and that is value of the house or what we can get out of a given house

given [1,2,3] and I am at house with value 3 - what can be my max earnings? - answer is when I choose subset [1,3], in other words if I am choosing 3 (and because of given constraint) the next element I can choose is 1. in other words, if I choose 3 the next solution is going to the max at (index of 3 -1)


*/

// Time : O(n) : n is the number of houses
// Space : O(1) : size for do array will be constant
func rob(nums []int) int {

	// edge case
	if len(nums) == 1 {
		// there is only one house to rob
		return nums[0]
	}

	// max for a given subset
	dp := make([]int, len(nums))
	// init some value
	dp[0] = nums[0]
	dp[1] = max(nums[0], nums[1])

	for i := 2; i < len(nums); i++ {
		// why i-2 : because we cannot ron two houses next to each other
		dp[i] = max(dp[i-1], (nums[i] + dp[i-2]))
	}
	fmt.Println(dp)
	return dp[len(dp)-1]

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
