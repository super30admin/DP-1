// Time Complexity : O(n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : few issues with the edge cases


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        if(nums == null || nums.length ==0) return 0;
        
        if(nums.length == 1) return nums[0];
        if(nums.length ==2) return Math.max(nums[0], nums[1]);
        
        int[][] moneyArr = new int[nums.length][nums.length];
        
        moneyArr[0][0] = nums[0];
        moneyArr[1][1] = nums[0];
        
        int MAX_MONEY = nums[0];
        
        for(int i=0; i< nums.length -2;i++) {
            for(int j= i+2; j< nums.length; j++) {
                int money = moneyArr[i][j-2] + nums[j];
                MAX_MONEY = Math.max(MAX_MONEY, money);
                
                moneyArr[i][j] = money;
            }
        }
        
        return MAX_MONEY;
    }
}