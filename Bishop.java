import java.util.*;
public class Bishop extends Piece{
    public Bishop(Cord loc, String color, boolean alive) {
        super(loc, "Bishop", color, alive);
    }
    
    public ArrayList<Cord> getPossibleCord(Piece[][] board) {
        ArrayList<Cord> output = new ArrayList<Cord>();
        int originalX = getLoc().getX();
        int originalY = getLoc().getY();
        int currentX = originalX;
        int currentY = originalY;
        while (currentX > 0 && currentY > 0) {
            currentY--;
            currentX--;
            if (board[currentY][currentX] == null) {
                output.add(new Cord(currentX, currentY));
            } else if (!board[currentY][currentX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(currentX, currentY));
                break;
            } else {
                break;
            }
        }
        currentX = originalX;
        currentY = originalY;
        while (currentX > 0 && currentY < 7) {
            currentY++;
            currentX--;
            if (board[currentY][currentX] == null) {
                output.add(new Cord(currentX, currentY));
            } else if (!board[currentY][currentX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(currentX, currentY));
                break;
            } else {
                break;
            }
        }
        currentX = originalX;
        currentY = originalY;
        while (currentX < 7 && currentY > 0) {
            currentY--;
            currentX++;
            if (board[currentY][currentX] == null) {
                output.add(new Cord(currentX, currentY));
            } else if (!board[currentY][currentX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(currentX, currentY));
                break;
            } else {
                break;
            }
        }
        currentX = originalX;
        currentY = originalY;
        while (currentX < 7 && currentY < 7) {
            currentY++;
            currentX++;
            if (board[currentY][currentX] == null) {
                output.add(new Cord(currentX, currentY));
            } else if (!board[currentY][currentX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(currentX, currentY));
                break;
            } else {
                break;
            }
        }
        return output;
    }
}
