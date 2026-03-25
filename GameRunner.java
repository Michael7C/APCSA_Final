import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import java.util.ArrayList;
public class GameRunner extends JPanel /*implements Runnable, KeyListener*/{


    // use ImageIcon for pictures
    private Piece[][] boardPieces;
    private Cord selected;
    private static JButton[][] boardSpaces;
    private King bKing;
    private King wKing;
    private String turn;

    public GameRunner() {
        super(new GridLayout(8, 8));
        selected = null;
        boardSpaces = new JButton[8][8];
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col < 8; col++) {
                String text = "";
                // text = (col) + "," +  (row);
                boardSpaces[row][col] = new JButton(text);
                boardSpaces[row][col].setOpaque(true);
                boardSpaces[row][col].setBorder(null);
                if ((row + col)%2 != 0) {
                    boardSpaces[row][col].setBackground(new Color(226, 213, 187));
                } else {
                    boardSpaces[row][col].setBackground(new Color(97, 111, 199));
                }
                add(boardSpaces[row][col]);
                // only did this to be able to use variable in action listenrer
                final int x = col;
                final int y = row;
                boardSpaces[row][col].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Click " + (x) + "," + (y));
                        movePiece(new Cord(x, y));
                        if (selected !=  null) {
                            System.out.println(boardPieces[selected.getY()][selected.getX()].getPossibleCord(boardPieces));
                        }
                        updateBoard();
                    }
                });
            }
        }
        boardPieces = new Piece[8][8];
        turn = "White";
        resetBoard();
    }

    public void movePiece(Cord loc) {
        if (selected == null && boardPieces[loc.getY()][loc.getX()] != null) {
            if (boardPieces[loc.getY()][loc.getX()].getColor().equals(turn)) {
                selected = loc;
            }
        } else if (selected != null) {
            boolean moved = boardPieces[selected.getY()][selected.getX()].move(boardPieces, loc);
            if (moved) {
                if (boardPieces[loc.getY()][loc.getX()].getColor().equals("White")) {
                    turn = "Black";
                } else {
                    
                    turn = "White";
                }
            }
            selected = null;
        }
        System.out.println(selected);
    }



    public void resetBoard() {
        turn = "White";
        for (int row = 1; row < 8; row += 5) {
            String color = "";
            if (row == 1) color = "White";
            if (row == 6) color = "Black";
            for (int col = 0; col < 8; col++) {
                Pawn temp = new Pawn(new Cord(col, row), color, true);
                boardPieces[row][col] = temp;
            }
        }
        for (int row = 0; row < 8; row += 7) {
            String color = "";
            if (row == 0) color = "White";
            if (row == 7) color = "Black";
            for (int col = 0; col < 8; col += 7) {
                Rook temp = new Rook(new Cord(col, row), color, true);
                boardPieces[row][col] = temp;
            }
            for (int col = 1; col < 8; col += 5) {
                Knight temp = new Knight(new Cord(col, row), color, true);
                boardPieces[row][col] = temp;
            }
            for (int col = 2; col < 8; col += 3) {
                Bishop temp = new Bishop(new Cord(col, row), color, true);
                boardPieces[row][col] = temp;
            }
            Queen tempQ = new Queen(new Cord(3, row), color, true);
            boardPieces[row][3] = tempQ;
        }
        wKing = new King(new Cord(4, 0), "White", true);
        bKing = new King(new Cord(4, 7), "Black", true);
        boardPieces[0][4] = wKing;
        boardPieces[7][4] = bKing;
        // boardPieces[4][5] = new Knight(new Cord(5, 4), "White", true);
        printBoard();
    }


    




    public void printBoard() {
        for (int row = 7; row >= 0; row--) {
            System.out.print("|");
            for (int col = 0; col < 8; col++) {
                Piece current = boardPieces[row][col];
                String color = "";
                if (current != null) {
                    if (current.getColor().equals("White")) {
                        System.out.print("W");
                        color = "W";
                    } else if (current.getColor().equals("Black")) {
                        System.out.print("B");
                        color = "B";
                    }
                }
                if (current == null) {
                    System.out.print("  ");
                    boardSpaces[row][col].setIcon(null);
                } else if (current instanceof Pawn) {
                    System.out.print("p");
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "pawn.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Rook) {
                    System.out.print("r");
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "rook.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Knight) {
                    System.out.print("k");
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "knight.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Bishop) {
                    System.out.print("b");
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "bishop.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Queen) {
                    System.out.print("q");
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "queen.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof King) {
                    System.out.print("K");
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "king.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                }
                boardSpaces[row][col].setOpaque(true);
                boardSpaces[row][col].setBorder(null); 
                System.out.print("|");
            }
            System.out.println();
        }
        
    }

    public void updateBoard() {
        for (int row = 7; row >= 0; row--) {
            for (int col = 0; col < 8; col++) {
                Piece current = boardPieces[row][col];
                String color = "";
                if (current != null) {
                    if (current.getColor().equals("White")) {
                        color = "W";
                    } else if (current.getColor().equals("Black")) {
                        color = "B";
                    }
                }
                if (current == null) {
                    boardSpaces[row][col].setIcon(null);
                } else if (current instanceof Pawn) {
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "pawn.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Rook) {
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "rook.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Knight) {
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "knight.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Bishop) {
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "bishop.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof Queen) {
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "queen.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                } else if (current instanceof King) {
                    ImageIcon temp = new ImageIcon(getClass().getResource("images/" + color + "king.png"));
                    Image other = temp.getImage();
                    boardSpaces[row][col].setIcon(new ImageIcon(other.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
                }
                boardSpaces[row][col].setOpaque(true);
                boardSpaces[row][col].setBorder(null); 
            }
        }
    }
}
