/**
 * Java 1 Homevork 3
 *
 * Author Ivan Gurenkov
 * @versiom 17.11.2021
 */

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("You Win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI Win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }
        System.out.println("Game Over");
    }
    public static boolean checkWin(char symb) {
        for (int i = 0; i < 3; i++)
        if ((map[i][0] == symb && map[i][1] == symb &&
                         map[i][2] == symb) ||
                (map[0][i] == symb && map[1][i] == symb &&
                                  map[2][i] == symb))
            return true;
        if ((map[0][0] == symb && map[1][1] == symb &&
                  map[2][2] == symb) ||
                    (map[2][0] == symb && map[1][1] == symb &&
                      map[0][2] == symb))
            return true;
    return false;
        
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("AI Choice " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Your Choice X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); 
        map[y][x] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}