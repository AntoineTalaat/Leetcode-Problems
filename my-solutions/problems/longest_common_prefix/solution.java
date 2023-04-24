class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int minLength = 300;
        for(String str: strs ){
            if(str.length()<minLength)
                minLength=str.length();
        }
        String commPrfx="";
        for(int i=0;i<minLength;i++){
            System.out.println(i);
            char current = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++ ){
                if(strs[j].charAt(i)!=current){
                    current='X';
                }
            }
            if(current != 'X')
                commPrfx = commPrfx + current;
            else
                break;
        }
        return commPrfx;
    }
}