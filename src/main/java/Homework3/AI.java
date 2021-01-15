package Homework3;

public class AI {
    private static int MAX_DEPTH;

    public static int[] getBestMove(Field field) {
        int[] bestMove = new int[]{-1, -1};
        int bestValue = Integer.MIN_VALUE;

        for (int row = 0; row < field.FIELD_HEIGHT; row++) {
            for (int col = 0; col < field.FIELD_WIDTH; col++) {
                if (field.isEmptyMarker(row, col)) {
                    field.makeAiTurn(row, col);
                    int moveValue = miniMax(field, MAX_DEPTH, false);
                    field.clearMarker(row, col);
                    if (moveValue > bestValue) {
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }

    public static int miniMax(Field field, int depth, boolean isMax) {
        int boardVal = evaluateBoard(field, depth);

        if (Math.abs(boardVal) > 0 || depth == 0 || field.isDraw()) {
            return boardVal;
        }

        if (isMax) {
            int highestVal = Integer.MIN_VALUE;
            for (int row = 0; row < field.FIELD_HEIGHT; row++) {
                for (int col = 0; col < field.FIELD_WIDTH; col++) {
                    if (field.isEmptyMarker(row, col)) {
                        field.makeAiTurn(row, col);
                        highestVal = Math.max(highestVal, miniMax(field,
                                depth - 1, false));
                        field.clearMarker(row, col);
                    }
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int row = 0; row < field.FIELD_HEIGHT; row++) {
                for (int col = 0; col < field.FIELD_WIDTH; col++) {
                    if (field.isEmptyMarker(row, col)) {
                        field.makeHumanTurn(row, col);
                        lowestVal = Math.min(lowestVal, miniMax(field,
                                depth - 1, true));
                        field.clearMarker(row, col);
                    }
                }
            }
            return lowestVal;
        }
    }

    private static int evaluateBoard(Field field, int depth) {
        if (field.checkWin(Field.AI_MARKER)) {
            return 10 + depth;
        } else if (field.checkWin(Field.HUMAN_MARKER)) {
            return -10 - depth;
        }

        return 0;
    }

    public static void initializeAiMaxDepth(Field field) {
        MAX_DEPTH = field.FIELD_HEIGHT > 4 && field.FIELD_WIDTH > 4 ? 3 : 6;
    }
}
