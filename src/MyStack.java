import java.util.NoSuchElementException;

public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();  // Используем MyArrayList для реализации стека
    }

    // Добавить элемент в стек (в конец списка)
    public void push(T item) {
        list.add(item);
    }

    // Удалить элемент из стека (с конца списка)
    public T pop() {
        if (list.size() == 0) throw new NoSuchElementException("Stack is empty");
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    // Получить верхний элемент стека без удаления
    public T peek() {
        if (list.size() == 0) throw new NoSuchElementException("Stack is empty");
        return list.get(list.size() - 1);
    }

    // Проверка на пустоту стека
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
