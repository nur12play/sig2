import java.util.NoSuchElementException;

public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.size() == 0) throw new NoSuchElementException("Queue is empty");
        T item = list.get(0);  // Получаем первый элемент
        list.remove(0);  // Удаляем первый элемент
        return item;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
