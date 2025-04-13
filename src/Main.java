public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());

        arrayList.remove(0);
        arrayList.remove(0);

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());

        arrayList.remove(0);

        System.out.println("Is ArrayList empty? " + arrayList.isEmpty());
    }
}
