// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class houseRobberSolution {
    public static int rob(int[] nums) {
        int taken = 0;
        int notTaken = 0;
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int prevRowNotTaken = notTaken;
            notTaken = Math.max(notTaken, taken);
            taken = nums[i] + prevRowNotTaken;
            
            max = Math.max(max, Math.max(notTaken,taken));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1};
        int result ;
        result = rob(nums);
        System.out.println(result);
    }

}