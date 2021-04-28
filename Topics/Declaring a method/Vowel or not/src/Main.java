import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        char[] vowel = "aeiouAEIOU".toCharArray();
        for (int i = 0; i < vowel.length; i++) {
            if (ch == vowel[i]) {
                return true;
            }
        }
        return false;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}