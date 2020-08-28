// Time Complexity : O(N) - N - number of houses
// Space Complexity : O(1) - constant space
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

public class Problem2 {

    public static int Rob(int[] nums){

        int C=0, DC= 0;
        for(int num:nums){
            int temp = DC;
            DC = Math.max(DC,C);
            C = temp+num;  
        }

        return Math.max(C,DC);

    }

    public static void main(String[] args){
        int house[] = {2,7,9,3,1};
        System.out.println(Rob(house));
    }
    
}