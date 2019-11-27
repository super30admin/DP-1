/**
Leet Code Submitted : YES
Space Complexity : O(N)
Time Complexity : O(N)
The idea is to refer to old decision when selecting any house. So, to pick any house we see whats the best we can do before that including it and adding it to maxMoney array then we will pick the max available option 
**/

class Solution {
    public int rob(int[] nums) {
        int[] maxMoney = new int[nums.length];
        Arrays.fill(maxMoney,-1);
        int max = 0;
        
        if(nums == null || nums.length == 0)
            return 0;
        
        if(nums.length == 1)
            return nums[0];
        
        
        for(int i = 0; i<nums.length; i++){
                if(i-2 >= 0){
                    maxMoney[i] = maxMoney[i-2] + nums[i];
                    if(maxMoney[i] > max)
                        max = maxMoney[i];
                    else
                        maxMoney[i] = max;
                }else{
                    maxMoney[i] = nums[i];
                    if(maxMoney[i] > max)
                        max = maxMoney[i];
                    else
                        maxMoney[i] = max;                        
                }
        }
        
        return maxMoney[nums.length - 1]; 
        
    }
}