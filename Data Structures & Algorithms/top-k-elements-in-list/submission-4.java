class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        ArrayList<Integer> output = new ArrayList<Integer>(); 
        for(int i =0; i<nums.length; i++){
            int key = nums[i];
            map.putIfAbsent(key,0);
            int count = map.get(key);
            count++;
            map.put(key,count);
            
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int count = entry.getValue();
            if(bucket[count]==null){
                bucket[count]= new ArrayList<Integer>();
            }
            bucket[count].add(key);
        }

        for(int i=bucket.length-1;i>-1;i--){
            if(bucket[i]==null){
                continue;
            }
            for(int val : bucket[i]){
                
                output.add(val);
                if(output.size()==k){
                break;
            }
            }
            if(output.size()==k){
                break;
            }
        }
        int[] returnVal = new int[k];
        for(int i = 0;i<returnVal.length;i++){
            returnVal[i]=output.get(i);
        }
        return returnVal;
        
    }
}
