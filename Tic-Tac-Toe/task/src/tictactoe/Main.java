package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println("---------");
        System.out.println("| " + str.charAt(0) + " " +
                str.charAt(1) + " " + str.charAt(2) + " |");
        System.out.println("| " + str.charAt(3) + " " +
                str.charAt(4) + " " + str.charAt(5) + " |");
        System.out.println("| " + str.charAt(6) + " " +
                str.charAt(7) + " " + str.charAt(8) + " |");
        System.out.println("---------");

        showGameState(str);
    }
        private static void showGameState(String str) {
            char[][] arr = parseString(str);

            if ((checkForWinner(arr, 'X') && checkForWinner(arr, 'O'))
                    || checkForDifference(arr)) {
                System.out.println("Impossible");
            } else if (checkForWinner(arr, 'X')) {
                System.out.println("X wins");
            } else if (checkForWinner(arr, 'O')) {
                System.out.println("O wins");
            } else if (checkForDraw(arr)) {
                System.out.println("Draw");
            } else {
                System.out.println("Game not finished");
            }
        }

        private static char[][] parseString(String str) {
            char[][] arr = new char[3][3];
            int counter = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = str.charAt(counter++);
                }
            }
            return arr;
        }

        private static boolean checkForWinner(char[][] arr, char ch) {
            if ((checkForWinnerColumns(arr, ch) || checkForWinnerRows(arr, ch) || checkForWinnerDiagonals(arr, ch))) {
                return true;
            }
            return false;
        }

        public static boolean checkForDraw(char[][] arr) {
            int counter = 0;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 'X' || arr[i][j] == 'O') {
                        counter++;
                    }
                }
            }
            return counter == 9;
        }

        private static boolean checkForDifference(char[][] arr) {
            int counterX = 0;
            int counterO = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 'X') {
                        counterX++;
                    } else if (arr[i][j] == 'O') {
                        counterO++;
                    }
                }
            }
            return ((counterX - counterO >= 2) || (counterO - counterX >= 2));
        }

        private static boolean checkForWinnerRows(char[][] arr, char ch) {

            for(int i = 0; i < arr.length; i++) {
                int counter = 0;
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == ch) {
                        counter++;
                    }
                }
                if (counter == 3) {
                    return true;
                }
            }
            return false;
        }

        private static boolean checkForWinnerColumns(char[][] arr, char ch) {

            for(int i = 0; i < arr.length; i++) {
                int counter = 0;
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[j][i] == ch) {
                        counter++;
                    }
                }
                if (counter == 3) {
                    return true;
                }
            }
            return false;
        }

        private static boolean checkForWinnerDiagonals (char[][] arr, char ch) {
            if ((arr[0][0] == ch && arr[1][1] == ch && arr[2][2] == ch)
                    || (arr[0][2] == ch && arr[1][1] == ch && arr[2][0] == ch )) {
                return true;
            }
            return false;
        }
}
