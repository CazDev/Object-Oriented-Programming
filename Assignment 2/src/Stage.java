import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.*;

public class Stage {
    Grid grid;
    ArrayList<Actor> actors;
    List<Cell> cellOverlay;
    List<MenuItem> menuOverlay;
    Optional<Actor> actorInAction;
    
    StateController stateController;

    // enum State {ChoosingActor, SelectingNewLocation, CPUMoving, SelectingMenuItem, SelectingTarget}
    // State currentState = State.ChoosingActor;


    
    public Stage(){
        grid = new Grid();
        actors = new ArrayList<Actor>();
        cellOverlay = new ArrayList<Cell>();
        menuOverlay = new ArrayList<MenuItem>();
        stateController = new StateController();
        stateController.setState(stateController.ChoosingActor);
    }

    public void paint(Graphics g, Point mouseLoc){

        // do we have AI moves to make
        if (stateController.getState() == stateController.CPUMoving){
            for(Actor a: actors){
                if (!a.isTeamRed()){
                    List<Cell> possibleLocs = getClearRadius(a.loc, a.moves, true);

                    Cell nextLoc = a.strat.chooseNextLoc(possibleLocs);

                    a.setLocation(nextLoc);
                }
            }
            stateController.setState(stateController.ChoosingActor);
            for(Actor a: actors){
                a.turns = 1;
            }
        }
        grid.paint(g,mouseLoc);
        
        Color col = new Color(1f, 0f, 1f, 0.8f);
        if (stateController.getState() == stateController.SelectingTarget){
            col = new Color(1f, 0f, 0f, 0.8f);
        }
        else if (stateController.getState() == stateController.SelectingNewLocation){
            col = new Color(1f, 0f, 1f, 0.8f);
        }
        
        grid.paintOverlay(g, cellOverlay, col);

        for(Actor a: actors){
            a.paint(g);   
        }
        
        // state display
        g.setColor(Color.DARK_GRAY);
        g.drawString(stateController.getState().toString(),Main.getScreenHeight(),20);

        // display cell
        Optional<Cell> cap = grid.cellAtPoint(mouseLoc);
        if (cap.isPresent()){
            Cell capc = cap.get();
            g.setColor(Color.DARK_GRAY);
            g.drawString(String.valueOf(capc.col) + String.valueOf(capc.row), Main.getScreenHeight(), 50);
            g.drawString(capc.description, 820, 50);
            g.drawString("movement cost", Main.getScreenHeight(), 65);
            g.drawString(String.valueOf(capc.movementCost()), 820, 65);
        } 

        // agent display
        int yloc = 138;
        for(int i = 0; i < actors.size(); i++){
            Actor a = actors.get(i);
            g.drawString(a.getClass().toString(),Main.getScreenHeight(), yloc + 70*i);
            g.drawString("location:", 730, yloc + 13 + 70 * i);
            g.drawString(Character.toString(a.loc.col) + Integer.toString(a.loc.row), 820, yloc + 13 + 70 * i);
            g.drawString("redness:", 730, yloc + 26 + 70*i);
            g.drawString(Float.toString(a.redness), 820, yloc + 26 + 70*i);
            g.drawString("strat:", 730, yloc + 39 + 70*i);
            g.drawString(a.strat.toString(), 820, yloc + 39 + 70*i);
        }

        // menu overlay (on top of everything else)
        for(MenuItem mi: menuOverlay){
            mi.paint(g);
        }


    }

    public List<Cell> getClearRadius(Cell from, int size, boolean considerCost){
        List<Cell> init = grid.getRadius(from, size, considerCost);
        for(Actor a: actors){
            init.remove(a.loc);
        }
        return init;
    }

    public void mouseClicked(int x, int y){
    
        stateController.action(x, y, this, stateController);

    }

    public Optional<Actor> actorAt(Cell c){
        for(Actor a: actors){
            if (a.loc == c){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}