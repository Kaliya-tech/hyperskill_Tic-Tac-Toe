import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pole = scanner.nextInt();
        int day = scanner.nextInt();
        int n = scanner.nextInt();
            
        var result = pole / (day + n);
        System.out.println(result);
    }
}
