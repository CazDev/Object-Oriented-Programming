import java.awt.*;

class Grid {
    //fields
    Cell[][] cells = new Cell[20][20];
    
    Cell road;
    Cell mountain;
    Cell water;
    Cell grass;

    // constructor
    public Grid(){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                double d = Math.random();
                if (d < 0.16666){
                    //16.66% chance
                    cells[i][j] = new Road(10+35*i,10+35*j);
                }
                else if (d < 0.33333){
                    //16.66% chance
                    cells[i][j] = new Mountain(10+35*i,10+35*j);
                }
                else if (d < 0.5){
                    //16.66% chance
                    cells[i][j] = new Water(10+35*i,10+35*j);
                }
                else{
                    //50% chance which is 3 times more likely than others
                    cells[i][j] = new Grass(10+35*i,10+35*j);
                }
            }
        }
    }

    // methods
    public void paint(Graphics g, Point mousePos){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j].paint(g, mousePos);
            }
        }
    }

    public Cell cellAtColRow(int c, int r){
        return cells[c][r];
    }
}