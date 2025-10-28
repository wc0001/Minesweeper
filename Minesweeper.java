package main;

public class Minesweeper {
  char[] board;
  int mineCount;
  int boardHeight;
  int boardWidth;
  int revealedCount;
  public Minesweeper(int boardHeight, int boardWidth, int mineCount) {
    board = char[boardHeight * boardWidth];
    this.boardHeight = boardHeight;
    this.boardWidth = boardWidth;
    this.mineCount = mineCount;
    revealedCount = 0;
  }

  public void setSquare(int i, int j, char x) {
    board[i * size + j] = x;
  }

  public char getSquare(int i, int j) {
    return board[i * size + j];
  }

  public void populateMines() {
    int count = 0;
    while (count < mineCount) {
      for (int i = 0; i < boardHeight; i++) {
        for (int j = 0; j < boardWidth; j++) {
          if (getSquare(i, j) != 'X' && Math.randint(100) < 1) {
            count++;
            setSquare(i, j, 'X');
          }
        }
      }
    }
  }

  public void clickSquare(int i, int j) {
  }

  public int gameStatus() {
    int totalSquares = boardHeight * boardWidth;
    if (revealedCount + mineCount == totalSquares) {
    //you win.
    }
    if (revealedCount < 0) {
    //you lose.
    } else {
    //game continues.
    }
  }
}

          
