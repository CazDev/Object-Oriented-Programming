import java.awt.*;

public class Road extends Cell {

    public Road(int x, int y) {
        super(x, y);
        this.color = Color.DARK_GRAY;
        this.movementCost = 1;
        this.cellType = "Road";
    }

}