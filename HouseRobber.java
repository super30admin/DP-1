public class HouseRobber {
    Map<Integer,Integer> memo = new HashMap();
    
    public int rob(int[] nums) {
        return helper(nums,-2);
    }
    
    public int helper(int [] nums,int index){
         if(memo.get(index)!=null) return memo.get(index);
        
        if(index>=nums.length){
            return 0;
        }
        int ans=0;
        int maxAnswer=0;
        for(int i=index+2;i<nums.length;i++){
           ans = helper(nums,i)+nums[i];
            maxAnswer = Math.max(maxAnswer,ans);
        }
         memo.put(index,maxAnswer);
        return maxAnswer;
    }
}