import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        boolean descOrdered = a > 0 && a < 10;
        System.out.println(descOrdered);

    }
}
