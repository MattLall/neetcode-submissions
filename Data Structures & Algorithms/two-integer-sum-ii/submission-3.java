class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // int[] output = new int[2];
        for(int i = 0;i<numbers.length;i++){
            // int p1=i;
            // int p2=numbers.length-1;
            int curr=numbers[i];
            int currTarg = target-curr;
            // if(currTarg==curr) continue;
            if(currTarg>numbers[numbers.length-1]) continue;
            int targIndex = binarySearch(Arrays.copyOfRange(numbers,i+1,numbers.length),currTarg);
            if(targIndex!=-1){
                return new int[]{i+1,targIndex+2+i};//+1 to i because answer is 1-indexed, +i to targIndex because subArray is sent to binary search, +2 to targIndex because i+1 is the start of the binary search array;
            }

        }
        return new int[2];
    }

    public int binarySearch(int[] numbers, int target){
        int left = 0;
        int right = numbers.length-1;

        while(left<=right){
            int middle = (left+right)/2;
            if(numbers[middle]==target) return middle;
            if(numbers[middle]>target){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }

        return -1;

    }
}
