class Solution {
    public boolean isPalindrome(int x) {
        int rem=0, rev=0;
        int n=x;
    while(x>0){
     rem = x%10;
     rev= (rev*10) + rem;
     x= x/10;
    }
    if(rev==n)
    return true;
    else
    return false;
    }
}