public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());  // Должно вывести true

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());  // Должно вывести false

        arrayList.remove(0);  // Удалим первый элемент
        arrayList.remove(0);  // Удалим второй элемент

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());  // Должно вывести false

        arrayList.remove(0);  // Удалим последний элемент

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());  // Должно вывести true
    }
}
