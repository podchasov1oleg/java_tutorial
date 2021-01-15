package Homework3;

import java.util.Scanner;

public class TicTacToe {
    private static Field field;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static char[] turnQueue;

    public static void main(String[] args) {
        beginGame();
    }

    private static void beginGame() {
        System.out.println("\nВведите ширину и высоту поля через пробел:");
        int w = SCANNER.nextInt();
        int h = SCANNER.nextInt();

        System.out.println("\nВведите необходиме количество фишек в ряд для победы:");
        int winLength = SCANNER.nextInt();

        field = new Field(w, h, winLength);
        field.print();

        AI.initializeAiMaxDepth(field);

        setTurnQueue();

        play();
    }

    private static void setTurnQueue() {
        double prob = Math.random();
        if (prob < 0.5d) {
            turnQueue = new char[]{Field.AI_MARKER, Field.HUMAN_MARKER};
        } else {
            turnQueue = new char[]{Field.HUMAN_MARKER, Field.AI_MARKER};
        }

    }

    private static void play() {
        boolean gameOver;
        do {
            gameOver = makeTurns();
        } while (!gameOver);
    }

    private static boolean makeTurns() {
        int row, col;
        for (char marker : turnQueue) {
            if (marker == Field.HUMAN_MARKER) {
                do {
                    System.out.println("\nВаш ход, введите координаты через пробел:");
                    row = SCANNER.nextInt() - 1;
                    col = SCANNER.nextInt() - 1;
                } while (!field.validCoordinates(row, col));
                field.makeHumanTurn(row, col);
            } else {
                int[] aiMove = AI.getBestMove(field);
                row = aiMove[0];
                col = aiMove[1];
                field.makeAiTurn(row, col);
                System.out.println("\nAI сделал свой ход:");
            }
            field.print();
            if (field.checkEnd()) return true;
        }
        return false;
    }
}
