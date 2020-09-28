import java.util.*;

public class SelectingTarget implements State {

    public void Action(int x, int y, Stage stage, StateController stateController){
        for(Cell c: stage.cellOverlay){
            if (c.contains(x, y)){
                Optional<Actor> oa = stage.actorAt(c);
                if (oa.isPresent()){
                    oa.get().makeRedder(0.1f);
                }
            }
        }
        stage.cellOverlay = new ArrayList<Cell>();
        stateController.setState(stateController.ChoosingActor);
    }
    
    public String toString() {
        return "SelectingTarget";
    }

}