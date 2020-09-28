import java.awt.*;

public class Mountain extends Cell {

    public Mountain(int x, int y) {
        super(x,y);
        this.color = Color.LIGHT_GRAY;
        this.movementCost = 10;
        this.cellType = "Mountain";
    }

}