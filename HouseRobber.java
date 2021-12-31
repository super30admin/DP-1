// Time Complexity : O(N) where N is length of input array
// Space Complexity : O(N) where N is length of input array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.*;
public class HouseRobber {
    public static void main(String[] args){
        int [] houses = {1,2,1,1};
        System.out.println(rob(houses));
    }

    public static int rob(int[] houses) {
        if(houses == null){
            return 0;
        }
        int[] dp = new int[houses.length];
        Arrays.fill(dp, -1);
        return helper(houses, 0, dp);
    }
    
    private static int helper(int[] houses, int index, int[] dp) {
        //base case
        if(index >= houses.length){
            return 0;
        }

        //logic
        if(dp[index] > -1){
            return dp[index];
        }
        //pick
        int pick = helper(houses, index + 2, dp) + houses[index];

        //no pick
        int notPick = helper(houses, index + 1, dp);

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }
}
