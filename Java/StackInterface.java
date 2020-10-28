package vale.pullRequest.second;

public interface StackInterface<T> {
    void put(T t);
    T    pop();
    T    peek();

    boolean isEmpty();
    boolean isFull();
}
