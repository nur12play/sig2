public interface MyHeap<T extends Comparable<T>> {
    void insert(T item);
    T extractMin();
    T peek();
    int size();
    boolean isEmpty();
}
