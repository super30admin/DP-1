// TC : O(n)
// SC : O(1)

class Solution {
    public int rob(int[] nums) {
        
        int not_choose = 0;
        int temp = not_choose;
        int choose = 0;
        
        for(int i = 0; i < nums.length; i++) {
            not_choose = Math.max(choose, not_choose);
            choose = temp+nums[i];
            temp = not_choose;
        }
        return Math.max(choose, not_choose);
    }
}
