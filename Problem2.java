//198.
// Exhaustive Approach- recursion
class Solution {
    int maxMoneyRob = 0;
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int index, int moneyRob){
        //base case
        if(index >= nums.length){
            if(moneyRob>=maxMoneyRob){
                maxMoneyRob = moneyRob;
            }
            return moneyRob;
        }

        int case1 = helper(nums,index+1,moneyRob);
        int case2 = helper(nums,index+2,moneyRob + nums[index]);

        return maxMoneyRob;
    }
} 


//DP

class Solution {

    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        int[][] dpArr = new int[nums.length+1][2];
        dpArr[0][0] = 0;
        dpArr[0][1] = 0;

        for (int i = 1; i<= nums.length; i++){
            dpArr[i][0] = Math.max(dpArr[i-1][0],dpArr[i-1][1]);
            dpArr[i][1] = nums[i-1] + dpArr[i-1][0];
        }

        return Math.max(dpArr[dpArr.length-1][0], dpArr[dpArr.length-1][1]);



    }

} 