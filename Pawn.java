import java.util.*;
public class Pawn extends Piece{
    
    public Pawn(Cord loc, String color, boolean alive) {
        super(loc, "Pawn", color, alive);
    }
    
    
    public ArrayList<Cord> getPossibleCord(Piece[][] board) {
        ArrayList<Cord> output = new ArrayList<Cord>();
        int currentX = getLoc().getX();
        int currentY = getLoc().getY();
        
        if (getColor().equals("White")) {

            if (currentY < 7) {
                if (board[currentY + 1][currentX] == null) {
                    output.add(new Cord(currentX, currentY + 1));
                    if (currentY == 1) {
                        if (board[currentY + 2][currentX] == null) {
                            output.add(new Cord(currentX, currentY + 2));
                        }
                    }
                }
                if (currentX < 7) {
                    if (board[currentY + 1][currentX + 1] != null) {
                        if (board[currentY + 1][currentX + 1].getColor().equals("Black")) {
                            output.add(new Cord(currentX + 1, currentY + 1));
                        }
                    }
                }
                if (currentX > 0) {
                    if (board[currentY + 1][currentX - 1] != null) {
                        if (board[currentY + 1][currentX - 1].getColor().equals("Black")) {
                            output.add(new Cord(currentX - 1, currentY + 1));
                        }
                    }
                }
            }
        } else if (getColor().equals("Black")) {
            if (currentY > 0) {
                if (board[currentY - 1][currentX] == null) {
                    output.add(new Cord(currentX, currentY - 1));
                    if (currentY == 6) {
                        if (board[currentY - 2][currentX] == null) {
                            output.add(new Cord(currentX, currentY - 2));
                        }
                    }
                }
                if (currentX < 7) {
                    if (board[currentY - 1][currentX + 1] != null) {
                        if (board[currentY - 1][currentX + 1].getColor().equals("White")) {
                            output.add(new Cord(currentX + 1, currentY - 1));
                        }
                    }
                }
                if (currentX > 0) {
                    if (board[currentY - 1][currentX - 1] != null) {
                        if (board[currentY - 1][currentX - 1].getColor().equals("White")) {
                            output.add(new Cord(currentX - 1, currentY - 1));
                        }
                    }
                }
            }
    }
        return output;    
    }

    @Override
    public ArrayList<Cord> getPossibleCheck(Piece[][] board) {
        ArrayList<Cord> output = new ArrayList<Cord>();
        int currentX = getLoc().getX();
        int currentY = getLoc().getY();
        
        if (getColor().equals("White")) {

            if (currentY < 7) {
                if (currentX < 7) {
                    if (board[currentY + 1][currentX + 1] != null) {
                        if (board[currentY + 1][currentX + 1].getColor().equals("Black")) {
                            output.add(new Cord(currentX + 1, currentY + 1));
                        }
                    }
                }
                if (currentX > 0) {
                    if (board[currentY + 1][currentX - 1] != null) {
                        if (board[currentY + 1][currentX - 1].getColor().equals("Black")) {
                            output.add(new Cord(currentX - 1, currentY + 1));
                        }
                    }
                }
            }
        } else if (getColor().equals("Black")) {
            if (currentY > 0) {
                if (currentX < 7) {
                    if (board[currentY - 1][currentX + 1] != null) {
                        if (board[currentY - 1][currentX + 1].getColor().equals("White")) {
                            output.add(new Cord(currentX + 1, currentY - 1));
                        }
                    }
                }
                if (currentX > 0) {
                    if (board[currentY - 1][currentX - 1] != null) {
                        if (board[currentY - 1][currentX - 1].getColor().equals("White")) {
                            output.add(new Cord(currentX - 1, currentY - 1));
                        }
                    }
                }
            }
    }
        return output;    
    }




}
