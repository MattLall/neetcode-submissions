class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // int[][] cars = new int[position.length][2](); //[x][0]=position, [x][1]=speed
        int fleets=0;
        int[][] pairs = new int[position.length][2];
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i<position.length;i++){
            Stack<int[]> temp = new Stack<>();
            int[] car = new int[3];
            car[0]=position[i];
            car[1]=speed[i];
            // car[2]= (target-car[0])/car[1];
            pairs[i]=car;
            
        }

        Arrays.sort(pairs,(a,b)->Integer.compare(b[0],a[0]));

        for(int[] car : pairs){
            double time = ((double)target-car[0])/car[1];
            // System.out.println(time);
            if(stack.isEmpty()){
                stack.push(time);
            }else{
                if(stack.peek()<time){
                    stack.push(time);
                }
            }
        }
        return stack.size();
    }
}
