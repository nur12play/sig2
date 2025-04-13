public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.addFirst(5);
        arrayList.addLast(40);
        System.out.println("ArrayList: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: ");
        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue: ");
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20

        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(30);
        minHeap.insert(10);
        minHeap.insert(20);
        System.out.println("MinHeap: ");
        System.out.println(minHeap.extractMin()); // 10
    }
}
