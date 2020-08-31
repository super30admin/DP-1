// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Problem_2 {
	
	 public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int moneyIfSelected = nums[0];
        int moneyIfNotSelected = 0;
        for(int i=1; i<nums.length ; i++ ){
            int temp = moneyIfSelected;
            moneyIfSelected = moneyIfNotSelected + nums[i];
            moneyIfNotSelected = Math.max(temp, moneyIfNotSelected);
        }
        return Math.max(moneyIfSelected, moneyIfNotSelected);
    }
}
