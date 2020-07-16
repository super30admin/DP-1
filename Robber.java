//Time: O(N),
//Space: O(1)
//Ran on LC, No issues

class Solution {
    public int rob(int[] arr) {
      if(arr.length==0){return 0;}
        else if(arr.length==1){return arr[0];}
        else{
            int first = arr[0];
            int second = 0;
            for(int i=1; i<arr.length; i++){
                int temp = first;
                first = Math.max(first, second+arr[i]);
                second = temp;
            }
            return first;
        }  
    }
}
