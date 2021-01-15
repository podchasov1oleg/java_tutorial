package Homework3;

public class Field {
    private char[][] field;
    public final int FIELD_WIDTH;
    public final int FIELD_HEIGHT;
    private static final char EMPTY_MARKER = 32;
    public static final char HUMAN_MARKER = 'X';
    public static final char AI_MARKER = 'O';
    private final int MARKERS_TO_WIN;

    public Field(int width, int height, int markersToWin) {
        this.FIELD_WIDTH = width;
        this.FIELD_HEIGHT = height;
        this.MARKERS_TO_WIN = markersToWin;
        initializeField();
    }

    private void initializeField() {
        this.field = new char[this.FIELD_HEIGHT][this.FIELD_WIDTH];

        for (int row = 0; row < this.FIELD_HEIGHT; row++) {
            for (int col = 0; col < this.FIELD_WIDTH; col++) {
                this.field[row][col] = EMPTY_MARKER;
            }
        }
    }

    public void print() {
        for (int row = 0; row < this.FIELD_HEIGHT; row++) {
            if (row == 0) {
                System.out.print("  ");
                for (int i = 0; i < this.field[row].length; i++) {
                    System.out.print((i + 1) + "|");
                }
                System.out.print("\n");
            }
            for (int col = 0; col < this.FIELD_WIDTH; col++) {
                if (col == 0) {
                    System.out.print((row + 1) + "|");
                }
                System.out.print(this.field[row][col]);
                System.out.print("|");
            }
            if (row != this.field.length - 1) {
                System.out.println("\n" + ("-".repeat(this.field[row].length * 2 + 2)));
            }
        }
        System.out.println("\n");
    }

    public boolean checkEnd() {
        if (this.checkWin(HUMAN_MARKER)) {
            System.out.println("Победил человек");
            return true;
        } else if (this.checkWin(AI_MARKER)) {
            System.out.println("Победил AI");
            return true;
        } else if (this.isDraw()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    public boolean checkWin(char marker) {
        //необходимо пробежаться по полю
        for (int row = 0; row < this.FIELD_HEIGHT; row++) {
            for (int col = 0; col < this.FIELD_WIDTH; col++) {
                if (
                    this.checkRow(row, col, marker) ||
                    this.checkColumn(row, col, marker) ||
                    this.checkDiagonalForward(row, col, marker) ||
                    this.checkDiagonalBackward(row, col, marker)
                ) return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row, int column, char marker) {
        boolean result = false;
        if (this.FIELD_WIDTH - column >= this.MARKERS_TO_WIN) {
            result = true;
            for (int i = 0; i < this.MARKERS_TO_WIN; i++) {
                result = this.field[row][column + i] == marker && result;
            }
        }
        return result;
    }

    private boolean checkColumn(int row, int column, char marker) {
        boolean result = false;
        if (this.FIELD_HEIGHT - row >= this.MARKERS_TO_WIN) {
            result = true;
            for (int i = 0; i < this.MARKERS_TO_WIN; i++) {
                result = this.field[row + i][column] == marker && result;
            }
        }
        return result;
    }

    private boolean checkDiagonalForward(int row, int column, char marker) {
        boolean result = false;
        if (this.FIELD_HEIGHT - row >= this.MARKERS_TO_WIN && this.FIELD_WIDTH - column >= this.MARKERS_TO_WIN) {
            result = true;
            for (int i = 0; i < this.MARKERS_TO_WIN; i++) {
                result = this.field[row + i][column + i] == marker && result;
            }
        }
        return result;
    }

    private boolean checkDiagonalBackward(int row, int column, int marker) {
        boolean result = false;
        if (this.FIELD_HEIGHT - row >= this.MARKERS_TO_WIN && column + 1 >= this.MARKERS_TO_WIN) {
            result = true;
            for (int i = 0; i < this.MARKERS_TO_WIN; i++) {
                result = this.field[row + i][column - i] == marker && result;
            }
        }
        return result;
    }

    public boolean isDraw() {
        for (int row = 0; row < this.FIELD_HEIGHT; row++) {
            for (int col = 0; col < this.FIELD_WIDTH; col++) {
                if (this.field[row][col] == EMPTY_MARKER) return false;
            }
        }
        return true;
    }

    public boolean validCoordinates(int row, int col) {
        if (row < 0 || row > this.FIELD_WIDTH || col < 0 || col > this.FIELD_HEIGHT) return false;
        return this.field[row][col] == EMPTY_MARKER;
    }

    public void makeHumanTurn(int row, int col) {
        this.field[row][col] = HUMAN_MARKER;
    }

    public void makeAiTurn(int row, int col) {
        this.field[row][col] = AI_MARKER;
    }

    public boolean isEmptyMarker(int row, int col) {
        return this.field[row][col] == EMPTY_MARKER;
    }

    public void clearMarker(int row, int col) {
        this.field[row][col] = EMPTY_MARKER;
    }
}
