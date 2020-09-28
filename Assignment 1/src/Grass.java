import java.awt.*;
import java.util.Random;

public class Grass extends Cell {

    public Grass(int x, int y) {
        super(x,y);
        Random rand = new Random();
        this.color = new Color(rand.nextInt(100), rand.nextInt((255 - 130) + 1) + 130, rand.nextInt(100));
        this.movementCost = (int)(color.getGreen()-100)/50;
        this.cellType = "Grass";
    }

}