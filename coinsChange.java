/*
    Time Complexity: O(A * N) ; A = total amount, N = total coins
    Space Complexity: O(A); A = total amount 
 */
 
 /*
  Approach:
   1. Create the array totalSum with length = amount + 1.
   Copy amount + 1 to each array location except the first location; first array location = 0
   This array indices represents the sum- sub problems and corresponding values at the 
   corresponding location represents the minimum number of coins required to make the sum- subproblems
   2. Iterate from 1 through the amount and again iterate from 0 through coins.length until the 
   loop is terminated, execute the condition totalSum[i] = Math.min(totalSum[i], totalSum[i - coins[j]] + 1);
   in the nested loop.
   3. The last element of the array will correspond to the minimum number of coins required to make 
   the given amount
   4. If the minimum number of coins required to make the amount exceeds the given amount then this 
   minimum number does not exist. But if the minimum number of coins are less than the amount then
   the last element of totalSum array represents the minimum number of coins required to make 
   the amount, return the last element of totalSum array.
 */





class coinChange {
    public int coinChange(int[] coins, int amount) {
        int maxSum = amount + 1;
        int[] totalSum = new int[maxSum];
        Arrays.fill(totalSum, maxSum);
        totalSum[0] = 0;
        for(int i = 1 ; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i) {
                    totalSum[i] = Math.min(totalSum[i], totalSum[i - coins[j]] + 1);
                }
            }
        }
        return totalSum[amount] > amount ? -1 : totalSum[amount];
    }
}