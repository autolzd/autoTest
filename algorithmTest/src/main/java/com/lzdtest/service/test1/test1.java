//package com.lzdtest.service.test1;
//
//import java.util.Scanner;
//
//public class test1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Gomoku game = new Gomoku();
//
//        System.out.println("Welcome to Gomoku! You are the X player. Let's start!");
//
//        while (!game.isFull() && !game.checkWin(Gomoku.X)) {
//            System.out.println("Enter your move (row column):");
//            int row = in.nextInt();
//            int col = in.nextInt();
//
//            game.move(row, col, Gomoku.X);
//            game.printBoard();
//
//            if (game.isFull() || game.checkWin(Gomoku.X)) {
//                break;
//            }
//
//            System.out.println("Computer's turn:");
//            game.computerMove();
//            game.printBoard();
//        }
//
//        if (game.checkWin(Gomoku.X)) {
//            System.out.println("You win!");
//        } else if (game.checkWin(Gomoku.O)) {
//            System.out.println("Computer wins!");
//        } else {
//            System.out.println("It's a draw!");
//        }
//    }
//}
