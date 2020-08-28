public class Cell {
    private final int x, y;
    private final boolean bomb;
    private boolean visited;

    public Cell(int x, int y, boolean bomb) {
        this.x = x;
        this.y = y;
        this.bomb = bomb;
    }

    public void visit() {
        this.visited = true;
    }
}
