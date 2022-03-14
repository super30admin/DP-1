package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(rob([]int{6, 9, 8, 1, 1, 5}))
}

// time: o(m)
// space: o(mn)
func rob(nums []int) int {

	if nums == nil || len(nums) == 0 {
		return 0
	}
	m := len(nums)
	n := 2
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	dp[0][1] = nums[0]

	for i := 1; i < m; i++ {
		// not rob
		dp[i][0] = int(math.Max(float64(dp[i-1][0]), float64(dp[i-1][1])))

		// rob
		dp[i][1] = dp[i-1][0] + nums[i]
	}

	return int(math.Max(float64(dp[m-1][0]), float64(dp[m-1][1])))
}

func helper(houses []int, idx int, earning int) int {

	// base
	// the only type of leaf avail is when we are out of houses
	if idx >= len(houses) {
		return earning
	}

	// logic
	// case1, we choose to rob this house
	case1 := helper(houses, idx+2, earning+houses[idx])

	// case2, we choose NOT to rob this house
	case2 := helper(houses, idx+1, earning)

	return int(math.Max(float64(case1), float64(case2)))
}
