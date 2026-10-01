/*
Defines all tetraminoes.

Colors are defined as follows:
1: red
2: orange
3: yellow
4: green
5: light blue
6: dark blue
7: purple
8: grey (possible use as garbage/permanent lines
*/

public class Blocks {
    private boolean[][] grid;
    private int color;
    
    public Blocks(int size, int col) { 
        this.grid = new boolean[size][size];
        this.color = col;
    }
    
    public Blocks(boolean[][] grid, int col) {
        this.grid = grid;
        this.color = col;
    }
    
    public Blocks(Blocks piece, int col) {
        this.grid = new boolean[piece.grid.length][piece.grid.length];
        this.color = col;
        for (int n = 0; n < piece.grid.length; n++) {
            for (int m = 0; m < piece.grid.length; m++) {
                this.grid[n][m] = piece.grid[n][m];
            }
        }
    }
    
    public static Blocks T = new Blocks(new boolean[][] {
        {false, true,  false},
        {true,  true,  true},
        {false, false, false}
    }, 7); // purple

    public static Blocks J = new Blocks(new boolean[][] {
        {true,  false, false},
        {true,  true,  true},
        {false, false, false}
    }, 6); // dark blue

    public static Blocks S = new Blocks(new boolean[][] {
        {false, true,  true},
        {true,  true,  false},
        {false, false, false}
    }, 4); // green

    public static Blocks Z = new Blocks(new boolean[][] {
        {true,  true,  false},
        {false, true,  true},
        {false, false, false}
    }, 1); // red
    
    public static Blocks O = new Blocks(new boolean[][] {
        {true, true,  false},
        {true, true,  false},
        {false, false, false}
    }, 3); // yellow

    public static Blocks L = new Blocks(new boolean[][] {
        {false, false, true},
        {true,  true,  true},
        {false, false, false}
    }, 2); // orange
    
    public static Blocks I = new Blocks(new boolean[][] {
        {false, false, false, false},
        {true, true, true, true},
        {false, false, false, false},
        {false, false, false, false}
    }, 5); // light blue
    
    public void simpleRotateBlockCounterClockwise() { // Counterclockwise matrix rotation
        int size = grid[0].length;
        boolean[][] newRotation = new boolean[size][size];
        for (int n = 0; n < size; n++) {
            for (int m = 0; m < size; m++) { 
                newRotation[size - m - 1][n] = grid[n][m];
            }
        }
        grid = newRotation;
    }
    
    public void simpleRotateBlockClockwise() { // Clockwise matrix rotation.
        int size = grid[0].length;
        boolean[][] newRotation = new boolean[size][size];
        for (int n = 0; n < size; n++) {
            for (int m = 0; m < size; m++) { 
                newRotation[m][size - n - 1] = grid[n][m];
            }
        }
        grid = newRotation;
    }
    
    public void simpleRotate180() { // 180 matrix rotation
        int size = grid[0].length;
        boolean[][] newRotation = new boolean[size][size];
        for (int n = 0; n < size; n++) {
            for (int m = 0; m < size; m++) { 
                newRotation[size - n - 1][size - m - 1] = grid[n][m];
            }
        }
        grid = newRotation;
    }
    public void printPiece() { // debug method
        int size = grid[0].length;
        for (int n = 0; n < size; n++) {
            for (int m = 0; m < size; m++) { 
                System.out.print(grid[n][m] + " ");
            }
            System.out.println();
        }
    }
    
    public void placePiece(Board board) {
        int size = grid[0].length;
        for (int n = 0; n < size; n++) {
            for (int m = 0; m < size; m++) {
                if (grid[n][m]) {
                    board.fillSquare(n, m, color);
                }
            }
        }
    }
}