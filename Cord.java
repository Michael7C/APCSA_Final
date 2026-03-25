public class Cord {
    
    private int x;
    private int y;
    // Preconditions:
    // 1 <= x <= 8
    // 1 <= y <= 8
    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean equals(Cord other) {
        if (other.getY() == y && other.getX() == x) {
            return true;
        }
        return false;
    }

    public String toString() {
        return ("(" + x + "," + y + ")");
    }
}
