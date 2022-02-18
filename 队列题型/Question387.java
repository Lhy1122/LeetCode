class Solution {

    public interface Queue<E> {
    int getsize();
    boolean isempty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}

    public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getcapacity(){
        return data.length;
    }

    public int getsize(){
        return size;
    }

    public boolean isempty(){
        return size == 0;
    }

    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed, Index is not in range.");
        
        for(int i = size - 1; i >= index; i-- ){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format ("size = %d, capacity = %d \n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i ++){
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is not in range.");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is not in range.");
        data[index] = e;
    }

    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E delete(int index){
        if(index < 0 || index >= size )
            throw new IllegalArgumentException("Delete failed. Index is not in range.");
        E a = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        return a;
    }

    public E deleteFirst(){
        return delete(0);
    }

    public E deleteLast(){
        return delete(size - 1);
    }

    public void deleteElement(E e){
        if(find(e) == -1)
            throw new IllegalArgumentException("Delete failed, Can't find the parameter");
        delete(find(e));
    }

      
}

    public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    public int getsize(){
        return array.getsize();
    }

    public boolean isempty(){
        return array.isempty();
    }

    public int getcapacity(){
        return array.getcapacity();
    }

    public void enqueue(E e){
        array.addLast(e);
    }

    public E dequeue(){
        return array.deleteFirst();
    }

    public E getFront(){
        return array.getFirst();
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0; i < array.getsize(); i++){
            res.append(array.get(i));
            if(i != array.getsize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

}

    public int firstUniqChar(String s) {
        char [] www = s.toCharArray();
        ArrayQueue<Character> queue = new ArrayQueue<>(s.length() + 1);
        int res = -1;
        for(int i = 0; i < www.length; i++){
            queue.enqueue(www[i]);
        }
        for(int h = 0; h < s.length(); h++){
            int n = 0;
            for(int i = 0; i < www.length; i++){
                
                if(queue.getFront().equals(www[i])){
                    n++;
                }

            }

            if(n >= 2){
                queue.dequeue();
            }
            else {
                res = h;
                break;
            }
        }

        return res;

    }
}