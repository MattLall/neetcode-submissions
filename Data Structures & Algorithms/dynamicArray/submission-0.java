class DynamicArray {
public int[] array;
        public int size = 0;
    public DynamicArray(int capacity) {
        array = new int[capacity];
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        if(this.array[i]==0){
            size++;
        }
        this.array[i] = n;
    }

    public void pushback(int n) {
        if(this.size==this.array.length){
            this.resize();
        }
        this.array[size]=n;
        this.size++;
    }

    public int popback() {
        size--;
        return array[size];
    }

    private void resize() {
        int[] resized = new int[array.length*2];
        for(int i = 0; i<array.length;i++){
            resized[i]=array[i];
        }

        this.array=resized;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }
}
