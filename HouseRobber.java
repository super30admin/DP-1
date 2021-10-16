class Solution {
    public int rob(int[] nums) {
        int runningMax1, runningMax2 = runningMax1 = 0;
        for(int i=0;i<nums.length;i++){
            int currMax = runningMax2 + nums[i];
            runningMax2 = Math.max(runningMax1,runningMax2);
            runningMax1 = currMax;
        }
        return Math.max(runningMax1, runningMax2);
    }
}