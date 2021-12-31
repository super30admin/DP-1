class Solution {
    public int rob(int[] nums) {
        int skip=0;
        int noSkip=nums[0];
        int sum=noSkip;
        for(int i=1;i<nums.length;i++){
            int temp=skip;
            if(skip<noSkip){
                skip=noSkip;
            }
            noSkip=nums[i]+temp;
            if(noSkip>skip){
                sum=noSkip;
            }else{
                sum=skip;
            }
        }
        return sum;

    }
}