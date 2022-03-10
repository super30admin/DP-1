/**
 * Time complexity is exponential(2^n) - as we have two choices to make at every house
 * space complexity is O(1) but recursive stack would be exponential
 * 
 * time limit exceeds on leetcode.
 */
public class HouseRobberBruteForce {
    public int rob(int[] nums) {
        return rob(nums, 0, 0);
    }
    
    private int rob(int[] nums, int i, int amount) {
        if(i >= nums.length) {
            return amount;
        }
        // rob i
        int case1 = rob(nums, i+2, amount + nums[i]);
        // don't rob i
        int case2 = rob(nums, i+1, amount);
        
        return Math.max(case1, case2);
    }
}
