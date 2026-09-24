class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l1=0,r1=matrix.length-1;
        while(l1<=r1){
            int m1 = l1+((r1-l1)/2);
            int midStart = matrix[m1][0], midEnd = matrix[m1][matrix[m1].length-1];
            if(midStart==target || midEnd==target){
                return true;
            }else if(midStart<target && midEnd>target){
                //target would be in this row if present
                int l2=0,r2=matrix[m1].length-1;
                while(l2<=r2){
                    int m2 = l2 + ((r2-l2)/2);
                    int val = matrix[m1][m2];
                    if(val==target){
                        return true;
                    }else if(val>target){
                        r2=m2-1;
                    }else{
                        l2=m2+1;
                    }
                }
                return false;
            }else if(midStart>target){
                r1=m1-1;
            }else{
                l1=m1+1;
            }
        }
        return false;
    }
}
