package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(coinChange([]int{1, 2, 5}, 11))
}

// time: o(mn)
// space: o(mn)
func coinChange(coins []int, amount int) int {
	if coins == nil || len(coins) == 0 {
		return -1
	}

	m := len(coins) + 1 // +1 to add the dummy 0 row for pulling 0th case from above for row 1
	n := amount + 1
	dp := make([][]int, m)
	for idx, _ := range dp {
		dp[idx] = make([]int, n)
	}

	// fill out the dummy row (0, all cols)
	// we do not change dp[0][0] because inorder to make 0 amount with coins [0], the valid answer is 0
	// but for making $1,$2.... $11 with coins [0] = is not possible, therefore the inf val for the rest of the 0th row
	for i := 1; i < len(dp[0]); i++ {
		dp[0][i] = n
	}

	// now fill out the rest of matrix
	// while skipping the 0th row since thats dummy row and is already filled out
	for i := 1; i < len(dp); i++ {
		for j := 0; j < len(dp[0]); j++ {

			// 0th case from above
			// remember i our row, so to get the value from above cell
			// we can simply do i-1 ( above row ) , same col.
			notChooseCaseVal := dp[i-1][j]

			// the choosen case value may already be saved
			// if the current $coin > $amount ( j idx acts as our current subproblem amount)
			// then , we donot have a choosen case because choosing coin > amount will
			// make the amount negative ( for example: 5 is the coin, and amount is 1 )
			// if we choose 5 as our coin, that makes our amount -4 -- which is invalid
			// therefore if $coin > $amount - we imply the min coins needed for this is the
			// value above

			// how do we get current $coin value
			// - coins[i-1]
			// how do we get current $amount value
			// this is j
			currentCoinVal := coins[i-1]
			currentAmount := j
			if currentCoinVal > currentAmount {
				dp[i][j] = notChooseCaseVal
			} else {
				// we have already solved for this case and it is $coin steps back in current row
				dp[i][j] = int(math.Min(float64(notChooseCaseVal), float64(1+dp[i][j-currentCoinVal])))
			}
		}
	}
	fmt.Println(dp)
	result := dp[m-1][n-1]
	if result > amount {
		result = -1
	}
	return result
	//	return helper(coins, amount, 0, 0)
}

// brute force of our decision tree
func helper(coins []int, amount, i, numCoins int) int {
	// base
	if amount == 0 {
		return numCoins
	}
	if i > len(coins)-1 || amount < 0 {
		return -1
	}

	// recursion logic
	// choose this coin
	choosen := helper(coins, amount-coins[i], i, numCoins+1)

	// or not choose this coin
	notChoosen := helper(coins, amount, i+1, numCoins)

	if choosen == -1 {
		return notChoosen
	}
	if notChoosen == -1 {
		return choosen
	}

	// finally return the min between those 2 decisions
	return int(math.Min(float64(choosen), float64(notChoosen)))
}
