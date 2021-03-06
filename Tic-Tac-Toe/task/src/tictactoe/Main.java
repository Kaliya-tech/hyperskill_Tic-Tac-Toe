package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] arr = prepareField();
        drawField(arr);
        playGame(arr, scanner);
    }

    public static void playGame(char[][] arr, Scanner scanner) {
        while (!checkForDraw(arr)) {
            char ch = getSymbol(arr);
            promptMakeMove(arr, scanner);
            if (checkForWinner(arr, ch)) {
                drawField(arr);
                showGameState(arr);
                break;
            }
            drawField(arr);
        }
        if (checkForDraw(arr)) {
            System.out.println("Draw");
        }
    }

    public static char getSymbol(char[][] arr) {
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'X' || arr[i][j] == 'O') {
                    counter++;
                }
            }
        }
        if (counter % 2 != 0) {
            return 'O';
        } else {
            return 'X';
        }
    }

    private static char[][] prepareField() {
        char[][] arr = new char[3][3];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = ' ';
                counter++;
            }
        }
        return arr;
    }

    public static void setSymbol(char[][] arr, char ch, char row, char col) {
        int rowNum = Character.getNumericValue(row) - 1;
        int colNum = Character.getNumericValue(col) - 1;
        arr[rowNum][colNum] = ch;
    }

    public static void drawField(char[][] arr) {
        System.out.println("---------");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public static void promptMakeMove(char[][] arr, Scanner scanner) {
        System.out.println("Enter the coordinates:");
        String input = scanner.nextLine();
        char row = input.charAt(0);
        char col = input.charAt(2);

        checkInput(arr, row, col, scanner);
    }

    public static void checkInput(char[][] arr, char row, char col, Scanner scanner) {
        if (isNotNumber(row) || isNotNumber(col)) {
            System.out.println("You should enter numbers!");
            promptMakeMove(arr, scanner);
        } else if (isNumberNotFits(row) || isNumberNotFits(col)) {
            System.out.println("Coordinates should be from 1 to 3!");
            promptMakeMove(arr, scanner);
        } else if (isCellFilled(arr, row, col)) {
            System.out.println("This cell is occupied! Choose another one!");
            promptMakeMove(arr, scanner);
        } else {
            setSymbol(arr, getSymbol(arr), row, col);
        }
    }

    private static boolean isNotNumber(char ch) {
        String symbols = "0123456789";
        int counter = 0;
        for (int i = 0; i < symbols.length(); i++) {
            if (ch == symbols.charAt(i)) {
                counter++;
                break;
            }
        }
        return counter == 0;
    }

    private static boolean isCellFilled(char[][] arr, char row, char col) {
        int rowNum = Character.getNumericValue(row) - 1;
        int colNum = Character.getNumericValue(col) - 1;

        if (arr[rowNum][colNum] != ' ') {
            return true;
        }
        return false;
    }

    private static boolean isNumberNotFits(char ch) {
        return ch != '1' && ch != '2' && ch != '3';
    }

    private static void showGameState(char[][] arr) {
         if (checkForWinner(arr, 'X')) {
            System.out.println("X wins");
        } else if (checkForWinner(arr, 'O')) {
            System.out.println("O wins");
        } else if (checkForDraw(arr)) {
            System.out.println("Draw");
        } else if ((checkForWinner(arr, 'X') && checkForWinner(arr, 'O'))
                || checkForDifference(arr)) {
             System.out.println("Impossible");
         } else {
            drawField(arr);
        }
    }

    private static boolean checkForWinner(char[][] arr, char ch) {
        if (checkForWinnerColumns(arr, ch) || checkForWinnerRows(arr, ch) || checkForWinnerDiagonals(arr, ch)) {
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

        for (int i = 0; i < arr.length; i++) {
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
        for (int i = 0; i < arr.length; i++) {
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

    private static boolean checkForWinnerDiagonals(char[][] arr, char ch) {
        if ((arr[0][0] == ch && arr[1][1] == ch && arr[2][2] == ch)
                || (arr[0][2] == ch && arr[1][1] == ch && arr[2][0] == ch)) {
            return true;
        }
        return false;
    }
}