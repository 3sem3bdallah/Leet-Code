class Solution {
    public int maxOperations(String s) {
        int cnt = 0;
        int i = 0, n = s.length();
        int res = 0;
        while(i<n){
            if(s.charAt(i) == '1'){
                cnt++;
                i++;
            }
            else{
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
                res += cnt;
            }
        }
        return res;
    }
}