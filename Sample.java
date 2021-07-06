

// Your code here along with comments explaining your approach
 /**    Time Complexity : O(K*n) where k is the total amount, n is given coins
        * // Space Complexity : O(K)
        * // Did this code successfully run on Leetcode : yes
        * // Any problem you faced while coding this : yes
        *
        * // Your code here along with comments explaining your approach
  */
class problem19 {
    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int [] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1 ; i<=amount; i++){
            for(int j=0; j< coins.length; j++){
                if(i-coins[j] < 0){ break;}
                dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }

        return dp[amount] > amount ? -1: dp[amount];

 }
/**
 * // Time Complexity : O(n)
 * // Space Complexity : O(n)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : Struggled to create the formula to make the best choice between the available houses
 *
 *
 * // Your code here along with comments explaining your approach
 */
class problem20 {
    public int rob(int[] nums){

    if(nums.length ==0){
        return 0;
    }
    if(nums.length ==1){
        return nums[0];
    }else if((nums.length ==2)){
        return Math.max(nums[0], nums[1]);
    }

    int dp[] = new int[nums.length]; // creating an extra array to keep track of best choices made

    dp[0] = nums[0]; // first choice
    dp[1] = Math.max(nums[0],nums[1]); // best of first or second choice

        for(int i=2; i<nums.length; i++){

        int firstChoice = dp[i-2];
        int secondChoice = dp[i-1];
        int curHouse = nums[i];

        dp[i] = Math.max(curHouse+firstChoice, secondChoice);
    }

         return dp[nums.length-1];
}
}
