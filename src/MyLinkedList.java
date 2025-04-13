import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T>, Iterable<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        MyNode current = getNode(index);
        current.data = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (index == size) {
            add(item);
            return;
        }

        MyNode newNode = new MyNode(item);
        MyNode current = getNode(index);
        if (current.prev != null) {
            current.prev.next = newNode;
            newNode.prev = current.prev;
        } else {
            head = newNode;
        }
        current.prev = newNode;
        newNode.next = current;
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new IndexOutOfBoundsException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new IndexOutOfBoundsException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode current = getNode(index);
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new IndexOutOfBoundsException();
        head = head.next;
        if (head != null) head.prev = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new IndexOutOfBoundsException();
        tail = tail.prev;
        if (tail != null) tail.next = null;
        size--;
    }

    @Override
    public void sort() {
        if (size <= 1) return;
        head = mergeSort(head);
        MyNode current = head;
        while (current.next != null) {
            current.next.prev = current;
            current = current.next;
        }
        tail = current;
    }

    private MyNode mergeSort(MyNode node) {
        if (node == null || node.next == null) return node;

        MyNode middle = getMiddle(node);
        MyNode nextToMiddle = middle.next;
        middle.next = null;

        MyNode left = mergeSort(node);
        MyNode right = mergeSort(nextToMiddle);

        return sortedMerge(left, right);
    }

    private MyNode sortedMerge(MyNode left, MyNode right) {
        if (left == null) return right;
        if (right == null) return left;

        MyNode result;
        @SuppressWarnings("unchecked")
        Comparable<T> leftData = (Comparable<T>) left.data;

        if (leftData.compareTo(right.data) <= 0) {
            result = left;
            result.next = sortedMerge(left.next, right);
            if (result.next != null) result.next.prev = result;
        } else {
            result = right;
            result.next = sortedMerge(left, right.next);
            if (result.next != null) result.next.prev = result;
        }
        result.prev = null;
        return result;
    }

    private MyNode getMiddle(MyNode node) {
        if (node == null) return node;
        MyNode slow = node;
        MyNode fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; current != null; i++) {
            if (object == null) {
                if (current.data == null) return i;
            } else {
                if (object.equals(current.data)) return i;
            }
            current = current.next;
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; current != null; i--) {
            if (object == null) {
                if (current.data == null) return i;
            } else {
                if (object.equals(current.data)) return i;
            }
            current = current.prev;
        }
        return -1;
    }


    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.data;
            current = current.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }

    private MyNode getNode(int index) {
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
