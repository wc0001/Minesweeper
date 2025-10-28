package main;

public class Main {
  public static void main(String[] args) {
    Minesweeper ms = new Minesweeper(5, 5, 5);
    ms.populateMines();
    while (!ms.gameOver()) {
      //get input.
      //assume we have i and j from input.
      ms.clickSquare(i, j);
    }
    if (ms.gameWon()) {
      //win screen.
    } else {
      //loss screen.
}
//play again? 
}
}
