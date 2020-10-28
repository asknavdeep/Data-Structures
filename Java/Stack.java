package vale.pullRequest.second;

import java.util.Arrays;

/**
 * FIFO first in, first out
 * @param <T>
 */
public class Stack<T> implements StackInterface<T>{

    private int MAX_ARRAY = -1;
    private int size;
    private int capacity;
    private Object[] objects;

    {
        size = 0;
        capacity = 2;
        objects = new Object[capacity];
    }

    public Stack(){

    }

    public Stack(int max_array){
        if(max_array > 0)
            MAX_ARRAY = max_array;
    }

    private boolean expand(){
        if(isFull()) {
            return false;
        }
        capacity = (capacity*2);
        Object[] newObjects = new Object[capacity];

        for(int i=0; i<size; i++){
            newObjects[i] = objects[i];
        }
        this.objects = newObjects;
        return true;
    }

    @Override
    public void put(T t) {
        if(capacity == size){
            if(!expand())
                return;
        }
        objects[size] = t;
        size++;
    }

    @Override
    public T pop() {
        if(size!=0 && capacity!=0){
            T t = (T) objects[0];
            for (int i=0; i<size-1; i++){
                objects[i] = objects[i+1];
            }
            objects[size-1] = null;
            size--;
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        if(size!=0 && capacity!=0){
            T t = (T) objects[0];
            return t;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size == capacity && capacity == MAX_ARRAY && MAX_ARRAY!=-1;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.put("a");
        stack.put("b");
        stack.put("c");

        System.out.println("stack = " + stack);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
