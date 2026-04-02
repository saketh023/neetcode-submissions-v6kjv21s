class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = right;

        while(left<=right){
            double hours = 0;
            int k = left+(right-left)/2;
            
            for(int pile : piles){
                hours+=Math.ceil((double) pile/k);
            }

            if(hours<=h){
                result = k;
                right = k-1;
            }
            else{
                left=k+1;
            }
        }
        return result;
    }
}
