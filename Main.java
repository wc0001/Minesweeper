package main;

public class Main {
  public static void main(String[] args) {
    Minesweeper ms = new Minesweeper(5, 5, 5);
    ms.populateMines();
    while (!ms.gameOver()) {
      //get input.
      //assume we have i and j from input.
      //print the game.
      //ask for input.
      for (int i = 0; i < ms.boardHeight; i++) {
        System.out.print("\n");
        for (int j = 0; j < ms.boardWidth; j++) {
          char c = ms.getSquare(i, j);
          if (c == 'X') {
            System.out.print(" ");
          } else {
            System.out.print(c);
          }
        }
      }
      System.out.println("which row do you want to click?")
      int a = System.in();
      System.out.println("which column do you want to click");
      int b = System.in();
      ms.clickSquare(a, b);
    }
    if (ms.gameWon()) {
      //win screen.
      System.out.println("You win!");
    } else {
      //loss screen.
      System.out.println("You lose. :\");
}
//play again? 
}
}
