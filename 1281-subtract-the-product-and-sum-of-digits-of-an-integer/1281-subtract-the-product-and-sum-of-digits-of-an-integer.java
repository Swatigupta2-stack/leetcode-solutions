class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0,rem=0, prd=1;
        while(n>0){
            rem = n%10;
            sum += rem;
            prd *=rem;
            n= n/10;
        }
        return prd-sum;
    }
}