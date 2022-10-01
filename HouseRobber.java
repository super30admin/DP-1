// Time Complexity: O(N)
// Space Complexity: O(N)
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int numsLength = nums.length;
        /*int dpArray[][] = new int[numsLength][2];
        dpArray[0][1] = nums[0];*/
        
        int skip = 0;
        int take = nums[0];
        
        for(int i = 1; i < numsLength; i++){
            // Not choose criteria
            //dpArray[i][0] = Math.max(dpArray[i-1][0], dpArray[i-1][1]);
            int temp = skip;
            skip = Math.max(skip, take);
            
            // Choose criteria
            //dpArray[i][1] = dpArray[i-1][0] + nums[i];
            take = temp + nums[i];
        }
        
        //return Math.max(dpArray[numsLength - 1][0], dpArray[numsLength - 1][1]);
        return Math.max(skip, take);
    }
}
