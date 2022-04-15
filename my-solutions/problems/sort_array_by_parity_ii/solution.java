class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int current=0;
        int lookahead=0;
        while(current<nums.length && lookahead<nums.length){
            if(lookahead!=current)//searching
            {
                if(nums[lookahead]%2==current%2){
                    swap(nums,lookahead,current);
                    current=current+1;
                    lookahead=current;
                }else {
                    lookahead++;
                }
            }
            
            
            else {
                if(current%2==nums[current]%2) {
                current++;
                lookahead++;
                }
                else{
                lookahead++;
                 }
            }
            
        }
        return nums;
    }
    
    private static void swap(int[] a, int x, int y){
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
}