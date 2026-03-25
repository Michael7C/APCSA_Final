import java.util.*;
public class Queen extends Piece{
    public Queen(Cord loc, String color, boolean alive) {
        super(loc, "Queen", color, alive);
    }

    public ArrayList<Cord> getPossibleCord(Piece[][] board) {
        ArrayList<Cord> output = new ArrayList<Cord>();
        int originalX = getLoc().getX();
        int originalY = getLoc().getY();
        int currentX = originalX;
        int currentY = originalY;
        while (currentX > 0) {
            currentX--;
            if (board[originalY][currentX] == null) {
                output.add(new Cord(currentX, originalY));
            } else if (!board[originalY][currentX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(currentX, originalY));
                break;
            } else {
                break;
            }
        }
        currentX = originalX;
        while (currentX < 7) {
            currentX++;
            if (board[originalY][currentX] == null) {
                output.add(new Cord(currentX, originalY));
            } else if (!board[originalY][currentX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(currentX, originalY));
                break;
            } else {
                break;
            }
        }
        currentX = originalX;
        while (currentY > 0) {
            currentY--;
            if (board[currentY][originalX] == null) {
                output.add(new Cord(originalX, currentY));
            } else if (!board[currentY][originalX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(originalX, currentY));
                break;
            } else {
                break;
            }
        }
        currentY = originalY;
        while (currentY < 7) {
            currentY++;
            if (board[currentY][originalX] == null) {
                output.add(new Cord(originalX, currentY));
            } else if (!board[currentY][originalX].getColor().equals(board[originalY][originalX].getColor())) {
                output.add(new Cord(originalX, currentY));
                break;
            } else {
                break;
            }
        }
        currentX = originalX;
        currentY = originalY;
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
