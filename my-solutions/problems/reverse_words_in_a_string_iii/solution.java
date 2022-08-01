class Solution {
    public String reverseWords(String s) {
        String[] sdiv= s.split(" ");
        for(int j = 0 ; j<sdiv.length;j++){
            String h = sdiv[j];
            for(int i =0 ; i <(h.length()/2) ; i++){
                h=swap(h,i);
            }
            sdiv[j] = h;
        }
        String result= new String();
        result="";
        for(int i = 0; i<sdiv.length;i++){
            result+=sdiv[i];
            if(i!=sdiv.length-1) result+=' ';
        }
        return result;

    }

    private String swap(String s, int i){
        char[] sc = s.toCharArray();
        char temp = sc[i];
        sc[i] = sc[sc.length-1-i];
        sc[sc.length-1-i] = temp;

        return String.valueOf(sc);

    }


}