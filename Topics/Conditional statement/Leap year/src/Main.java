import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if((num % 4 == 0 && num % 100 != 0) || (num % 400 == 0)) {
            System.out.println("Leap");
        } else {
            System.out.println("Regular");
        }

    }
}