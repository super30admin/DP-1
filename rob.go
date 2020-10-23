// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
initialize d array with 0, 1 index set to num[0] and max of num[0 or 1]
after 1 index find max of curr + current - 2 or -1
return last index
*/

package main

import "fmt"

func rob(nums []int) int {
	if len(nums) < 1 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}

	//recursive method
	//return helper(nums, 0, 0)

	//array method
	tot := []int{}
	tot = append(tot, nums[0])
	tot = append(tot, max(nums[0], nums[1]))

	for i := 2; i < len(nums); i++ {
		tot = append(tot, max(nums[i] + tot[i - 2], tot[i - 1]))
	}

	return tot[len(tot) - 1]
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

func helper(nums []int, curr int, min int) int {
	//base
	if curr >= len(nums) {
		return min
	}
	//chosen
	case1 := helper(nums, curr + 2, min + nums[curr])
	case2 := helper(nums, curr + 1, min)
	if case1 > case2 {
		return case1
	}
	return case2
}

func MainRob() {
	fmt.Println(rob([]int {1,2,3,1})) //expected 4
}
