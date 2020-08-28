import java.util.ArrayList;
import java.util.List;

public class GameField {
    private Cell cellList[][];
    private int rowNumber;
    private int colNumber;
    public final int height;
    public final int width;

    public GameField(int height, int width) {
        this.height = height;
        this.width = width;
        cellList = new Cell[height][width];
    }

    public void addCell(Cell cell) {
        if (colNumber * rowNumber > height * width)
            return;

        if (colNumber > width) {
            colNumber = 0;
            rowNumber++;
        }
        cellList[rowNumber][colNumber++] = cell;

    }
}
