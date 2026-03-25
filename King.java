import java.util.*;
public class King extends Piece{
    public King(Cord loc, String color, boolean alive) {
        super(loc, "King", color, alive);
    }
    public ArrayList<Cord> getPossibleCord(Piece[][] board) {
        ArrayList<Cord> output = new ArrayList<Cord>();
        int originalX = getLoc().getX();
        int originalY = getLoc().getY();
        Cord[] points = {new Cord(originalX - 1, originalY - 1),new Cord(originalX - 1, originalY),
                        new Cord(originalX - 1, originalY + 1),new Cord(originalX, originalY - 1),
                        new Cord(originalX, originalY + 1),new Cord(originalX + 1, originalY - 1),
                        new Cord(originalX + 1, originalY),new Cord(originalX + 1, originalY + 1)};
        
        for (int index = 0; index < points.length; index++) {
            if (points[index].getX() >= 0 && points[index].getX() <=7) {
                if (points[index].getY() >= 0 && points[index].getY() <= 7) {
                    // if (!isCheck(board, points[index])) {
                        if (board[points[index].getY()][points[index].getX()] != null) {
                            if (!board[points[index].getY()][points[index].getX()].getColor().equals(getColor())) {
                                output.add(points[index]);
                            }
                        } else {
                            output.add(points[index]);
                        }   
                    // }
                }
            }
        }
        return output;
    }
    public boolean isCheck(Piece[][] board, Cord loc) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {
                    // if (!board[row][col].getColor().equals(getColor())) {
                        ArrayList<Cord> possible = board[row][col].getPossibleCheck(board);
                        for (int index = 0; index < possible.size(); index++) {
                            if (possible.get(index).equals(loc)) {
                                return true;
                            }
                        }
                    // }
                }
            }
        }
        return false;
    }
    public boolean isCheckmate(Piece[][] board) {
        int originalX = getLoc().getX();
        int originalY = getLoc().getX();
        for (int row = originalY - 1; row <= originalY + 1; row++) {
            for (int col = originalX - 1; col <= originalX + 1; col++) {
                if ((!isCheck(board, new Cord(row - 1, col - 1))) && (canMove(board, new Cord(row - 1, col - 1)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
