package numberguess;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CONNECT4 {
    // We define characters for our player R for red and G for green
    private static final char[] players = {'R', 'G'};
    private final int width, height;
    private final char[][] grid;
    private int lastCol = -1, lastTop = -1;

    public CONNECT4(int w, int h) {
        width = w;
        height = h;
        grid = new char[h][]; // Corrected: use height instead of width

        for (int i = 0; i < h; i++) {
            Arrays.fill(grid[i] = new char[w], '.');
        }
    }

    // We use streams to make a more concise method for representing the board
    public String toString() {
        return IntStream.range(0, width).mapToObj(Integer::toString).collect(Collectors.joining(" ")) + "\n" +
               Arrays.stream(grid).map(String::new).collect(Collectors.joining("\n"));
    }

    // Get string representation of the row containing the last play of user
    public String horizontal() {
        return new String(grid[lastTop]);
    }

    // Get string representation of the column containing the last play of user
    public String vertical() {
        StringBuilder sb = new StringBuilder(height);
        for (int h = 0; h < height; h++) {
            sb.append(grid[h][lastCol]);
        }
        return sb.toString();
    }

    // Get string representation of the '/' diagonal containing the last play of user
    public String slashDiagonal() {
        StringBuilder sb = new StringBuilder(height);
        for (int h = 0; h < height; h++) {
            int w = lastCol + lastTop - h;
            if (0 <= w && w < width) {
                sb.append(grid[h][w]);
            }
        }
        return sb.toString();
    }

    public String backslashDiagonal() {
        StringBuilder sb = new StringBuilder(height);
        for (int h = 0; h < height; h++) {
            int w = lastCol - lastTop + h;
            if (0 <= w && w < width) {
                sb.append(grid[h][w]);
            }
        }
        return sb.toString();
    }

    // Static method checking if substring is a str or not
    public static boolean contains(String str, String substring) {
        return str.contains(substring); // Corrected: Use contains() method
    }

    // Now we create a method checking if last play is a winning player or not
    public boolean isWinningPlay() {
        if (lastCol == -1) {
            System.err.println("No move has been made yet");
            return false;
        }

        char sym = grid[lastTop][lastCol];
        // Winning streak with the last play symbol
        String streak = String.format("%c%c%c%c", sym, sym, sym, sym);

        // Check if streak is in row, col, diagonal or backslash diagonal
        return contains(horizontal(), streak) || contains(vertical(), streak) || contains(slashDiagonal(), streak) || contains(backslashDiagonal(), streak);
    }

    // Prompts the user for a column, repeating until valid choice is done
    public void chooseAndDrop(char symbol, Scanner input) {
        while (true) {
            System.out.println("\nPlayer " + symbol + " turn: ");
            int col = input.nextInt();
            if (!(0 <= col && col < width)) {
                System.out.println("Column must be between 0 and " + (width - 1));
                continue;
            }

            for (int h = height - 1; h >= 0; h--) {
                if (grid[h][col] == '.') {
                    grid[lastTop = h][lastCol = col] = symbol;
                    return;
                }
            }
            System.out.println("Column " + col + " is full.");
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int height = 6;
            int width = 8;
            int moves = height * width;
            CONNECT4 board = new CONNECT4(width, height);
            System.out.println("Use 0-" + (width - 1) + " to choose a column");
            System.out.println(board);

            for (int player = 0; moves-- > 0; player = 1 - player) {
                char symbol = players[player];
                board.chooseAndDrop(symbol, input);
                System.out.println(board);
                if (board.isWinningPlay()) {
                    System.out.println("\nPlayer " + symbol + " wins!");
                    return;
                }
            }
            System.out.println("GAME OVER. NO WINNER..TRY AGAIN...");
        }
    }
}
