// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
import java.util.HashSet;

class houseRobber {
         public int rob(int[] nums) {
       if(nums==null||nums.length==0){
            return 0;
        }
        int[][] dp=new int[nums.length][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
    houseRobber rs = new houseRobber();
    int[] m1 = {1,2,3,1};
    int[] m2 = {2,7,9,3,1};
    System.out.println(rs.rob(m1));  // ans = 4
    System.out.println(rs.rob(m2));  // ans = 12
}

}