// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
initialize 2d array with extra row and column
set initial value to max and later fill out rest of the fields by min of current and previous memory
if result of last element is less than max then its valid
return it
*/

package main

import "fmt"

func coinChange(coins []int, amount int) int {
	if len(coins) == 0 { return 0 }
	x := len(coins)
	mat := make([][]int, x + 1)
	for i := 0; i < x + 1; i++ {
		mat[i] = make([]int, amount + 1)
	}
	m := len(mat)
	n := len(mat[0])
	for j:=1; j<n;j++{
		mat[0][j] = 9999
	}
	for i := 1; i < m; i++ {
		for j:=1;j<n;j++{
			if(j<coins[i-1]){
				mat[i][j] = mat[i-1][j]
			} else {
				if mat[i-1][j] < 1+mat[i][j-coins[i-1]] {
					mat[i][j] = mat[i-1][j]
				} else {
					mat[i][j] = 1+mat[i][j-coins[i-1]]
				}
			}
		}
	}
	result := mat[m-1][n-1]
	if result >= 9999 {
		return -1
	}
	return mat[m-1][n-1]
}

func MainCoinChange() {
	fmt.Println(coinChange([]int {1,2,5}, 11)) //expected 3
}
