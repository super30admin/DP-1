// Time Complexity : O(n)
// Explaination : n is length of nums as we go through the array once
// Space Complexity : O(1)
// Explaination : only 2 variables used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
// Time taken : 10

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int inc = 0, exl = 0;
        for(int n : nums){
            int temp = Math.max(inc, exl);
            inc = exl+n;
            exl = temp;

        }
        return Math.max(inc, exl);
    }
}
