import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = 0;

        for (int i = a; i <= b; i++) {
            n = n + i;
        }
        System.out.println(n);
    }
}