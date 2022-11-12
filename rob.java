// Time Complexity : O(n) 
// Space Complexity :O(1)  
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int case0=0, case1=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=case0;
            //case 0 means not chosing the house, if so then take the max from previos roberry
            case0=Math.max(case0,case1);
            //case 1 is current rob ammount + the last house case 0 amount;
            case1=temp+nums[i];
        }
        
        return Math.max(case0,case1);
    }
}