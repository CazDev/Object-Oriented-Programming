import java.awt.*;

class Cell extends Rectangle {
    // fields
    static int size = 35;
    Color color;
    int movementCost;
    String cellType;

    //constructors
    public Cell(int x, int y){
        super(x,y,size,size);
    }

    //methods
    void paint(Graphics g, Point mousePos){
        g.setFont(new Font("SegoeUI", Font.PLAIN, 16)); 
        if(contains(mousePos)){
            g.setColor(Color.BLACK);
            g.drawString("Cell type is: " + cellType, 730, 30);
            g.drawString("Movement cost is: " + movementCost, 730, 50);
            g.setColor(Color.GRAY);
        } else {
            g.drawString("Cell type is: ", 730, 30);
            g.drawString("Movement cost is: ", 730, 50);
            g.setColor(color);
        }
        g.fillRect(x,y,size,size);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,size,size);
    }

    public boolean contains(Point p){
        if (p != null){
            return super.contains(p);
        } else {
            return false;
        }
    }
    
    public String getCellType(){
        return cellType;
    }
    
    public int getMovementCost(){
        return movementCost;
    }
}