class Solution {
     long mod=1000000007;
    public int countGoodNumbers(long n) {
         
         return (int)((binaryExp(5,(n+1)/2))*binaryExp(4,(n/2))%mod);

    }
    public long binaryExp(int x, long y){
        long mul=x;
        long result=1;
        while(y>0){
            if((y&1)==1){
                result=(result*mul)%mod;
            }
            mul=(mul*mul)%mod;
            y/=2;
        }
        return result;
    }
}