import java.awt.*;

public class Water extends Cell {

    public Water(int x, int y) {
        super(x,y);
        this.color = Color.BLUE;
        this.movementCost = 100;
        this.cellType = "Water";
    }

}