    /*  Explanation
    # Leetcode problem link : NA
    Time Complexity for operators : o(m*2)
    Extra Space Complexity for operators : o(m*2) .. 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Followed the choose and don't choose approach as suggested in image. And found the repatative sub problem.
        # Optimized approach: . 
                              
            # 1. Form the two-d matrix. colum will be for choose and don't choose and row will be for amount in the houses.
              2. First row will be the value of first house amount and dont choose is zero as we didnt choose anything yet.
              3. Starting from first row and column, for choose option, we wll select the current value + DC value of previous column.
              4. for the dont choose option, we will select the maximum of choose and dont choose value of previous row.
              5. At the end, we will return the max of last two element that tell us the required o/p
    */  

public class houseRobber{
    public static void main(String args[]) {
                int nums[]= new int[] {2,7,9,3,1};
                System.out.println(houseRobberProblem(nums));
            }
            
            
            
        public static int houseRobberProblem(int nums[]) {
                
            if(nums == null || nums.length==0)
                return 0;
            
            int dp[][] = new int[nums.length][2]; 
            dp[0][0] = nums[0];
            dp[0][1] = 0;
            for(int i=1;i<nums.length;i++){
                dp[i][0] = nums[i] + dp[i-1][1];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
            }
            
            return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        }
}