package backtracking.sudoku;

import java.util.Arrays;

public class Sudoku {


    public static void main(String[] args) {
        String[][] puzzle =
                {
                        {"5", "3", "",      "", "7", "",        "", "", ""},
                        {"6", "", "",       "1", "9", "5",      "", "", ""},
                        {"", "9", "8",      "", "", "",         "", "6", ""},

                        {"8", "", "",       "", "6", "",        "", "", "3"},
                        {"4", "", "",       "8", "", "3",       "", "", "1"},
                        {"7", "", "",       "", "2", "",        "", "", "6"},

                        {"", "6", "",       "", "", "",         "2", "8", ""},
                        {"", "", "",        "4", "1", "9",      "", "", "5"},
                        {"", "", "",        "", "8", "",        "", "7", "9"},
                };
        String[] elements =
                {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        new Sudoku(puzzle, elements).run();
    }


    private final String[][] puzzle;
    private final String[] elements;
    private final boolean [][] rowUsed;
    private final boolean [][] columnUsed;
    private final boolean [][][] boxUsed;

    public Sudoku(String[][] puzzle, String[] elements) {
        checkPuzzleAndElements(puzzle, elements);
        this.puzzle = puzzle;
        this.elements = elements;
        int length = puzzle.length;
        this.rowUsed = new boolean[length][length];
        this.columnUsed = new boolean[length][length];
        this.boxUsed = new boolean[length/3][length/3][length];
    }

    private static void checkPuzzleAndElements(String[][] puzzle, String[] elements) {
        if (elements.length != puzzle.length) {
            throw new IllegalArgumentException("Invalid puzzle and elements");
        }
        for (int a = 0; a < puzzle.length; a++) {
            for (int b = 0; b < puzzle.length; b++) {
                if (puzzle[a].length != puzzle[b].length) {
                    throw new IllegalArgumentException("Invalid puzzle");
                }
            }
        }
    }


    public void run(){
        for (int a = 0; a < puzzle.length; a++) {
            for (int b = 0; b < puzzle[a].length; b++) {
                String element = puzzle[a][b];
                if (element.isEmpty()) {
                    continue;
                }
                int elementIndex;
                for (elementIndex = 0; elementIndex < elements.length; elementIndex++) {
                    if (elements[elementIndex].equals(element)) {
                        break;
                    }
                }
                useElement(a, b, elementIndex, true);
            }
        }
        solve(0, 0);
    }

    private void solve(int x, int y) {
        if (puzzle[x][y].isEmpty()) {
            for (int elementIndex = 0; elementIndex < elements.length; elementIndex++) {
                if (!isUsed(x, y, elementIndex)) {
                    useElement(x, y, elementIndex, true);
                    puzzle[x][y] = elements[elementIndex];
                    if (y < puzzle.length - 1) {
                        solve(x, y + 1);
                    } else if(x < puzzle.length - 1) {
                        solve(x + 1, 0);
                    } else {
                        printPuzzle(puzzle);
                    }
                    useElement(x, y, elementIndex, false);
                    puzzle[x][y] = "";
                }
            }
        } else {
            if (y < puzzle.length - 1) {
                solve(x, y + 1);
            } else if(x < puzzle.length - 1) {
                solve(x + 1, 0);
            } else {
                printPuzzle(puzzle);
            }
        }
    }

    private boolean isUsed(int x, int y, int elementIndex) {
        return rowUsed[x][elementIndex] || columnUsed[y][elementIndex] || isUsedInBox(x, y, elementIndex);
    }

    private boolean isUsedInBox(int x, int y, int elementIndex) {
        int boxX = x / 3;
        int boxY = y / 3;
        return boxUsed[boxX][boxY][elementIndex];
    }

    private void useElement(int x, int y, int elementIndex, boolean use) {
        int boxX = x / 3;
        int boxY = y / 3;
        rowUsed[x][elementIndex] = use;
        columnUsed[y][elementIndex] = use;
        boxUsed[boxX][boxY][elementIndex] = use;
    }

    private static void printPuzzle(String [][] puzzle) {
        for (int a = 0; a < puzzle.length; a++) {
            System.out.println(Arrays.toString(puzzle[a]));
        }
    }
}
