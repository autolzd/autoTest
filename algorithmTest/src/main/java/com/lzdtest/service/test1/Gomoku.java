package com.lzdtest.service.test1;

import java.util.Scanner;

public class Gomoku {
    static final int ROWS = 15;
    static final int COLUMNS = 15;
    static final char[][] BOARD = new char[ROWS][COLUMNS];
    static final char BLACK = 'B';
    static final char WHITE = 'W';

    public static void main(String[] args) {
        initBoard();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Black's turn:");
            int x = sc.nextInt();
            int y = sc.nextInt();
            BOARD[x][y] = BLACK;
            if (checkWin(x, y, BLACK)) {
                System.out.println("Black wins!");
                break;
            }
            printBoard();
            System.out.println("White's turn:");
            x = sc.nextInt();
            y = sc.nextInt();
            BOARD[x][y] = WHITE;
            if (checkWin(x, y, WHITE)) {
                System.out.println("White wins!");
                break;
            }
            printBoard();
        }
    }

    static void initBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                BOARD[i][j] = ' ';
            }
        }
    }

    static void printBoard() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14");
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(BOARD[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkWin(int x, int y, char color) {
        // check vertical
        int count = 0;
        for (int i = x - 4; i <= x + 4; i++) {
            if (i >= 0 && i < ROWS && BOARD[i][y] == color) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // check horizontal
        count = 0;
        for (int j = y - 4; j <= y + 4; j++) {
            if (j >= 0 && j < COLUMNS && BOARD[x][j] == color) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // check diagonal (upper left to lower right)
        count = 0;
        for (int i = x - 4, j = y - 4; i <= x + 4 && j <= y + 4; i++, j++) {
            if (i >= 0 && i < ROWS && j >= 0 && j < COLUMNS && BOARD[i][j] == color) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // check diagonal (upper right to lower left)
        count = 0;
        for (int i = x - 4, j = y + 4; i <= x + 4 && j >= y - 4; i++, j--) {
            if (i >= 0 && i < ROWS && j >= 0 && j < COLUMNS && BOARD[i][j] == color) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
