package Minesweeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MinesweeperGUI {
    private final Minesweeper ms;
    private final JFrame frame;
    private final JButton[][] buttons;

    public MinesweeperGUI(Minesweeper ms) {
        this.ms = ms;
        frame = new JFrame("Minesweeper");
        buttons = new JButton[ms.boardHeight][ms.boardWidth];
        frame.setLayout(new GridLayout(ms.boardHeight, ms.boardWidth));
        for (int i = 0; i < ms.boardHeight; i++) {
            for (int j = 0; j < ms.boardWidth; j++) {
                JButton button = new JButton(" ");
                buttons[i][j] = button;

                int row = i, col = j;
                button.addActionListener(e -> handleClick(row, col));
                frame.add(button);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private void handleClick(int i, int j) {
        ms.clickSquare(i, j);
        updateBoard();

        if (ms.gameOver()) {
            String message = ms.gameWon() ? "You win!" : "You lose!";
            JOptionPane.showMessageDialog(frame, message);
        }
    }

    private void updateBoard() {
        for (int i = 0; i < ms.boardHeight; i++) {
            for (int j = 0; j < ms.boardWidth; j++) {
                char c = ms.getSquare(i, j);

                buttons[i][j].setText(String.valueOf(c == 'X' ? ' ' : c));
            }
        }
    }
}
