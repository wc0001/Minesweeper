package main;

public class Minesweeper {
  char[] board;
  int mineCount;
  int boardHeight;
  int boardWidth;
  int score;
  public Minesweeper(int boardHeight, int boardWidth, int mineCount) {
    board = char[boardHeight * boardWidth];
    this.boardHeight = boardHeight;
    this.boardWidth = boardWidth;
    this.mineCount = mineCount;
    score = 0;
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
    if (getSquare(i, j) == 'X') {
      score = Integer.MIN_VALUE;
    } else if (getSquare(i, j) != '') {
      break;
    } else {
      score++;
      int mines = 0;
      int verticalLowerBound = Math.max(i - 1, 0);
      int verticalUpperBound = Math.min(i + 2, boardHeight);
      int horizontalLowerBound = Math.max(j - 1, 0);
      int horizontalUpperBound = Math.min(j + 2, boardWidth);
      for (int a = verticalLowerBound; a < verticalUpperBound; a++) {
        for (int b = horizontalLowerBound; b < horizontalUpperBound; b++) {
          if (getSquare(a, b) == 'X') {
            mines++;
          }
        }
      }
      setSquare(i, j, mines.toChar());
      if (mines == 0) {
        for (int a = verticalLowerBound; a < verticalUpperBound; a++) {
          for (int b = horizontalLowerBound; b < horizontalUpperBound; b++) {
            clickSquare(a, b);
          }
        }
      }
    }
  }

  public boolean gameLost() { 
    return score < 0;
  }
  public boolean gameWon() {
    return score + mineCount == boardWidth * boardHeight;
  }
  public boolean gameOver() {
    return gameLost() || gameWon();
  }
}

          
