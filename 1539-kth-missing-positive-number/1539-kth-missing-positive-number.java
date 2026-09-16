class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left =0, missing=0;
        int right = arr.length;
        while(left < right){
            int mid= left +(right-left)/2;
            missing = arr[mid]- (mid+1);
            if(missing<k)
            left = mid+1;
            else
            right = mid;

        }
        return left+k;

    }
}