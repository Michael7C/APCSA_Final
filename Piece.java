import java.util.*;
public abstract class Piece{
    private Cord loc;
    private String type;
    private String color;
    private boolean alive;
    public Piece(Cord loc, String type, String color, boolean alive) {
        this.loc = loc;
        this.type = type;
        this.color = color;
        this.alive = alive;
    }

    public Cord getLoc() {
        return loc;
    }
    public String getType() {
        return type;
    }
    public String getColor() {
        return color;
    }
    public boolean isAlive() {
        return alive;
    }




    public boolean canMove(Piece[][] board, Cord newLoc) {
        // if (!isAlive()) return false;
        // checks if cord is out of bounds
        if (newLoc.getX() < 0 || newLoc.getX() > 7 || newLoc.getY() < 0 || newLoc.getY() > 7) {
            return false;
        }
        ArrayList<Cord> possibleMoves = getPossibleCord(board);
        // System.out.println(possibleMoves);

        for (Cord oneLoc : possibleMoves) {
            if (oneLoc.equals(newLoc)) {
                return true;
            }
        }
        return false;
    }

    public boolean move(Piece[][] board, Cord newLoc) {
        if (canMove(board, newLoc)) {
            int newX = newLoc.getX();
            int newY = newLoc.getY();
            board[newY][newX] = board[getLoc().getY()][getLoc().getX()];
            board[getLoc().getY()][getLoc().getX()] = null;
            loc = newLoc;
            return true;
        }
        return false;
    }
    
    public abstract ArrayList<Cord> getPossibleCord(Piece[][] board);

    public ArrayList<Cord> getPossibleCheck(Piece[][] board) {
        return getPossibleCord(board);
    }

}
