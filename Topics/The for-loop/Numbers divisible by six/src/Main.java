import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int acc = 0;
        int x;
        for (int i = 0; i < num; i++) {
            x = scanner.nextInt();
            if (x % 6 == 0) {
                acc = acc + x;
            }
        }
        System.out.println(acc);
    }
}
