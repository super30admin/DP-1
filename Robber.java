// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Robber {
        public int rob(int[] nums) {
            if(nums.length==0|| nums==null){
                return 0;
            }
            int skip=0; int take=nums[0];
            
            for(int i=1;i<nums.length;i++){
                int temp=skip;
                skip=Math.max(skip,take);
                take=temp+nums[i];
            }
            return Math.max(skip,take);
        }
    
    public static void main(String args[]){
        Robber obj=new Robber();
        int nums[]={2,7,8,9,1};
        System.out.println(obj.rob(nums));
    }
}
