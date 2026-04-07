package priorityheaps;
class minHeap {
     int[] arr;
    private int size;
    minHeap(int capacity){
        arr = new int[capacity];
        size = 0;
    }
    public void add(int num){
        arr[size++]= num;
        upheapify(size-1);
    }
    public void upheapify(int i){
        if(i==0) return;
        int parent = (i-1)/2;
        if(arr[parent]>arr[i]){
            swap(parent,i);
        }
        upheapify(parent);
    }
    public void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int peek(){
        return arr[0];
    }
    public int size(){
        return size;
    }
    public int remove(){
        int temp =arr[0];
        size--;
        swap(0,size);
        downheapify(0);
        return temp;
    }
    public void downheapify(int parent){
        int smallest = parent;
        int child1 = 2 * parent + 1;
        int child2 = 2 * parent + 2;
        if(child1 < size && arr[child1] < arr[smallest]) smallest = child1;
        if(child2 < size && arr[child2] < arr[smallest]) smallest = child2;
        if(smallest != parent){
            swap(parent, smallest);
            downheapify(smallest);
        }
    }
}

public class minHeapImp {
    public static void main(String[] args) {
        minHeap h = new minHeap(5);
        h.add(1);
        h.add(6);
        h.add(0);
        h.add(2);
        h.add(-1);
        // for (int i = 0; i <5; i++) {
        //     System.out.print(h.arr[i]+" ");
        // }
        System.out.println(h.remove());
        System.out.println(h.peek());
        for (int i = 0; i <5; i++) {
            System.out.print(h.arr[i]+" ");
        }
        System.out.println(h.remove());
        System.out.println(h.peek());

    }
}
