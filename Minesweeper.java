package Minesweeper;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Minesweeper {
  char[] board;
  int mineCount;
  int boardHeight;
  int boardWidth;
  int score;
  boolean gameStarted;
  public Minesweeper(int boardHeight, int boardWidth, int mineCount) {
    board = new char[boardHeight * boardWidth];
    for (int i = 0; i < boardHeight * boardWidth; i++) {
        board[i] = ' ';
    }
    this.boardHeight = boardHeight;
    this.boardWidth = boardWidth;
    this.mineCount = mineCount;
    score = 0;
    gameStarted = false;
  }

  public void setSquare(int i, int j, char x) {
    board[i * boardWidth + j] = x;
  }

  public char getSquare(int i, int j) {
    return board[i * boardWidth + j];
  }

    private void populateMines(int safeRow, int safeCol) {
        List<int[]> cells = new ArrayList<>();
        // Add all possible cells except the safe cell (and optionally neighbors)
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (Math.abs(i - safeRow) <= 1 && Math.abs(j - safeCol) <= 1)
                    continue; // skip safe zone
                cells.add(new int[]{i, j});
            }
        }
        // Shuffle and pick first N cells for mines
        Collections.shuffle(cells, new Random());
        for (int i = 0; i < mineCount && i < cells.size(); i++) {
            int[] c = cells.get(i);
            setSquare(c[0], c[1], 'X');
        }
        gameStarted = true;
    }

  public void clickSquare(int i, int j) {
      if (!gameStarted) {
          populateMines(i, j);
      }
      if (getSquare(i, j) == 'X') {
      score = Integer.MIN_VALUE;
    } else if (getSquare(i, j) != ' ') {
      return;
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
      char c = (char) (mines + 48);
      setSquare(i, j, c);
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

          
