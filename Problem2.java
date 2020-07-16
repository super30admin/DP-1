// There are three approaches.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

// Approach 1. Brute force
// Time complexity: O(2^(n))
//      n: number of houses
// Space complexity: O(n)
//      n: number of houses
class Problem2BruteForce {

    /** find maximum amount that can be robbed by not robbing neighbor houses*/
    public int rob(int[] nums) {
        // base condition
        if(nums!=null && nums.length!=0)
            return helper(nums, 0, 0);
        return 0;
    }
    /**
     * Helper function
     * @param nums array of house
     * @param houseIndex current index of array
     * @param amount amount by robbing
     * @return int
     */
    private int helper(int[]nums, int houseIndex, int amount){

        // base condition array index out of bounds
        if(houseIndex >= nums.length)
            return amount;
        else{

            // find amount by not choosing to rob the curent house
            int notChose = helper(nums, houseIndex+1, amount);
            // here houseIdex increase by 1 as we have choice to rob second house

            // find amount by choosing to rob the curent house
            int chose = helper(nums, houseIndex+2, amount+nums[houseIndex]);
            // here houseIdex increase by 2 as we cannot rob second house

            // return max of choice
            return Math.max(notChose, chose);
        }
         
    }
}

// Approach 2. Dynamic programming 
// Time complexity: O(n))
//      n: number of houses
//       O(n*2) = O(n)
//          *2 signifies choice to rob/not rob.
// Space complexity: O(n)
//      n: number of houses
//      O(n*2) = O(n)
class Problem2DP1 {

    /** find maximum amount that can be robbed by not robbing neighbor houses*/
    public int rob(int[] nums) {

         // base condition
        if(nums==null || nums.length==0)
            return 0;
        // find using dp
        else{
            // dp matrix with two col
            // Oth Col:  not robbed cuurent
            // 1th Col: robbed current
            int[][] dp = new int [nums.length][2];

            // initial value
            dp[0][0] = 0;
            dp[0][1]= nums[0];

            // iterate
            for(int i=1;i<nums.length;i++){

                // 1. not robbing.. Free to chose either to rob previous or not
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); // max of either choice

                // 2. robbing
                dp[i][1] = nums[i] + dp[i-1][0]; 
                // current house value + previous house not robbed value
            }

            // max of not rob, robbed
            return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
        }
    }
}

// Approach 3. Dynamic programming with constant space
// Time complexity: O(n)
//      n: number of houses
// Space complexity: O(1)
//      O(4) = O(1)
class Problem2DP2 {

    /** find maximum amount that can be robbed by not robbing neighbor houses*/
    public int rob(int[] nums) {

         // base condition
        if(nums==null || nums.length==0)
            return 0;
        // find using dp
        else{
            
            // initial value
            int notRob = 0;
            int rob= nums[0];

            // iterate
            for(int i=1;i<nums.length;i++){

                // 1. not robbing.. Free to chose either to rob previous or not
                int curNotRob = Math.max(notRob, rob); // max of either choice
                
                // 2. robbing
                int curRob = nums[i] + notRob;
                // current house value + previous house not robbed value

                // updating to previous
                notRob = curNotRob;
                rob = curRob;
            }

            // max of not rob, robbed
            return Math.max(notRob, rob);
        }
    }
}