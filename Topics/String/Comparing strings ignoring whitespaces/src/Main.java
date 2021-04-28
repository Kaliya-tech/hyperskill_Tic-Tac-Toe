import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().replace(" ", "");
        String str2 = scanner.nextLine().replace(" ", "");

        System.out.println(str.equals(str2));
        
    }
}
