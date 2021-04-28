import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int result = 0;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (i > result) {
                result = i;
            } else {
                (i = result)
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(result);
    }
}