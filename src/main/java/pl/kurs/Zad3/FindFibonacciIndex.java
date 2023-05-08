package pl.kurs.Zad3;

public class FindFibonacciIndex {
    public static void main(String[] args) {

        System.out.println(findFibonacciIndex(8));
    }


    static int findFibonacciIndex(int value) {
        if (value == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;
        int index = 1;

        while (b <= value) {
            int temp = b;
            b = a + b;
            a = temp;
            index++;

            if (b == value) {
                return index;
            }
        }

        return -1;
    }
}