import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine(); 
        
        char theFirstChar = str.charAt(0);
        String str2 = Character.toString(theFirstChar);
        boolean result = str2.equalsIgnoreCase("J");
        System.out.println(result);
      
    }
}
