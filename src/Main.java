public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();  // Указываем тип Integer
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(1, 15);  // Добавить элемент по индексу
        arrayList.set(2, 25);  // Обновить элемент по индексу
        arrayList.remove(3);   // Удалить элемент по индексу

        System.out.println("ArrayList:");
        for (Integer item : arrayList) {  // Указываем тип в цикле
            System.out.println(item);
        }

        // Тестирование MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();  // Указываем тип String
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.addFirst("Zero");
        linkedList.addLast("Last");
        linkedList.remove(1);  // Удалить элемент по индексу

        // Вывод элементов MyLinkedList
        System.out.println("\nLinkedList:");
        for (String item : linkedList) {  // Указываем тип в цикле
            System.out.println(item);
        }
    }
}
