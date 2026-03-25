import java.util.*;
public class Knight extends Piece{
    public Knight(Cord loc, String color, boolean alive) {
        super(loc, "Knight", color, alive);
    }

    public ArrayList<Cord> getPossibleCord(Piece[][] board) {
        ArrayList<Cord> output = new ArrayList<Cord>();
        int originalX = getLoc().getX();
        int originalY = getLoc().getY();
        Cord[] points = {new Cord(originalX - 2, originalY - 1),new Cord(originalX - 2, originalY + 1),
                        new Cord(originalX - 1, originalY - 2),new Cord(originalX + 1, originalY - 2),
                        new Cord(originalX + 2, originalY - 1),new Cord(originalX + 2, originalY + 1),
                        new Cord(originalX - 1, originalY + 2),new Cord(originalX + 1, originalY + 2)};
        for (int index = 0; index < points.length; index++) {
            if (points[index].getX() >= 0 && points[index].getX() <=7) {
                if (points[index].getY() >= 0 && points[index].getY() <= 7) {
                    if (board[points[index].getY()][points[index].getX()] != null) {
                        if (!board[points[index].getY()][points[index].getX()].getColor().equals(getColor())) {
                            output.add(points[index]);
                        }
                    } else {
                        output.add(points[index]);
                    }
                }
            }
        }
        return output;
    }
}
